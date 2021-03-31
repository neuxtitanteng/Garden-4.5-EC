package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.api.model.*;
import com.neux.garden.ec.runtime.exception.*;
import com.neux.garden.ec.runtime.jpa.bean.Sequences;
import com.neux.garden.ec.runtime.jpa.model.*;
import com.neux.garden.ec.runtime.jpa.repository.SequenceIDRepository;
import com.neux.garden.ec.runtime.service.bean.OrderStatus;
import com.neux.garden.ec.runtime.service.data.*;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Value("${Order.OrderId.Prefix:NEUX}")
    private String orderIdPrefix;

    @Value("${Order.Payment.ReturnURL}")
    private String orderPaymentReturnURL;

    @Value("${Order.Payment.ClientBackURL}")
    private String orderPaymentClickBackURL;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ExProductPointOverviewService exProductPointOverviewService;

    @Autowired
    private ExProductService exProductService;

    @Autowired
    private SequenceIDRepository sequenceIDRepository;

    @Autowired
    private DateService dateService;

    @Autowired
    private ExProductOrderService exProductOrderService;

    @Autowired
    private ExProductOrderDetailService exProductOrderDetailService;

    @Autowired
    private ExProductShoppingCarService exProductShoppingCarService;

    @Autowired
    private ProductService productService;

    @Transactional
    public SubmitOrderResponse submitOrder(String authorization, SubmitOrderRequest orderInfo) {

        String account = tokenService.getUsernameFromToken(authorization);
        Member member = memberService.findByID(account);
        if(member == null) throw new ProfileException(ErrorCode.NOT_FOUND_MEMBER);
        else if("N".equalsIgnoreCase(member.getIsOpen())) throw new ProfileException(ErrorCode.MEMBER_IS_EXPIRED);

        List<SubmitOrder> orders = orderInfo.getDatas();

        int totalPoint = 0;
        int totalCost = 0;
        List<String> tradeProductNames = new ArrayList<>();
        List<ExProductOrderDetail> detailList = new ArrayList<>();

        for(SubmitOrder submitOrder : orders) {
            String productId = submitOrder.getProductId();
            String pointType = submitOrder.getPointType();
            int quantity = submitOrder.getQuantity().intValue();

            //check the shopping cart product is exist
            ExProduct exProduct = exProductService.findByProductId(productId);
            if(exProduct == null) throw new ProductIsNotFoundException(productId);

            String productName = exProduct.getProductName();

            //check the shopping cart stock is enough
            if(exProduct.getStockCurrent() < quantity) throw new ProductStockIsNotEnoughException(productName);

            //check the shopping cart exchange-type is active
            ExProductPointOverview overviews = exProductPointOverviewService.findByIdentityProductIdAndIdentityCategoryId(productId,pointType);
            if(overviews == null) throw new ProductExchangeTypeExpiredException(productName);

            //sum total point & cost
            totalPoint += overviews.getPoint();
            totalCost += overviews.getExtraCost();

            //add product name
            tradeProductNames.add(productName);

            //create Order Detail
            ExProductOrderDetailIdentity identity = new ExProductOrderDetailIdentity();
            identity.setProductId(productId);

            ExProductOrderDetail orderDetail = new ExProductOrderDetail();
            orderDetail.setIdentity(identity);
            orderDetail.setQuantity(quantity);
            orderDetail.setPointCategoryName(overviews.getCategoryName());
            orderDetail.setProductName(productName);
            orderDetail.setPoint(overviews.getPoint());
            orderDetail.setCost(overviews.getExtraCost());

            orderDetail.setCreateBy(account);
            orderDetail.setCreateTime(dateService.getTodayDate());
            orderDetail.setUpdateBy(account);
            orderDetail.setUpdateTime(dateService.getTodayDate());

            detailList.add(orderDetail);
        }

        //check the member point is enough
        int memberPoint = member.getPoint();
        if(totalPoint > memberPoint) throw new MemberPointNotEnoughException();

        //=======START ORDER=======
        AioCheckOutALL aioCheckOutALL = createOrder(member,totalPoint,totalCost,detailList, String.join(",",tradeProductNames));
        AllInOne all = new AllInOne("");

        SubmitOrderResponse submitOrderResponse = new SubmitOrderResponse();

        SubmitOrderResult submitOrderResult = new SubmitOrderResult();
        submitOrderResult.setRedirect(aioCheckOutALL != null);
        submitOrderResult.setRedirectForm(aioCheckOutALL != null ? all.aioCheckOut(aioCheckOutALL,null) : "");

        submitOrderResponse.setBody(submitOrderResult);

        return submitOrderResponse;
    }

    @Transactional
    public AioCheckOutALL createOrder(Member member , int totalPoint , int totalCost, List<ExProductOrderDetail> detailList,String tradeDescription) {

        String account = member.getAccount();

        //create Order
        BigInteger sequenceOrderId = sequenceIDRepository.getSequenceID(Sequences.ExProductOrder);
        String orderId = orderIdPrefix + StringUtils.leftPad(sequenceOrderId.toString(),7,"0");

        ExProductOrder order = new ExProductOrder();
        order.setOrderId(orderId);
        order.setAccount(account);
        order.setStatus(OrderStatus.PENDING_PAYMENT.name());
        order.setPaymentType("CREDIT_CARD");
        order.setPoint(totalPoint);
        order.setCost(totalCost);
        order.setOrderDate(dateService.getTodayDate());
        order.setOrderYear(dateService.getCurrentYear());
        order.setOrderQuarter(dateService.getCurrentQuarter());
        order.setOrderMonth(dateService.getCurrentMonth());
        order.setCreateBy(account);
        order.setCreateTime(dateService.getTodayDate());
        order.setUpdateBy(account);
        order.setUpdateTime(dateService.getTodayDate());

        detailList.forEach(exProductOrderDetail -> {

            //set order id
            exProductOrderDetail.getIdentity().setOrderId(orderId);

            //reduct product stock
            int success = exProductService.updateStock(exProductOrderDetail.getQuantity(),exProductOrderDetail.getIdentity().getProductId());
            if(success < 0) throw new ProductStockIsNotEnoughException(exProductOrderDetail.getIdentity().getProductId());
        });

        exProductOrderService.save(order);
        exProductOrderDetailService.saveAll(detailList);

        //reduce member point
        member.setPoint(member.getPoint() - totalPoint);
        memberService.save(member);

        //clear member shoppingcart
        exProductShoppingCarService.clearMyShoppingCart(account);

        //create Payment Order
        if(totalCost > 0) {
            AioCheckOutALL obj = new AioCheckOutALL();
            obj.setMerchantTradeNo(orderId);
            obj.setMerchantTradeDate(dateService.toDateString(order.getOrderDate(),"yyyy/MM/dd HH:mm:ss"));
            obj.setTotalAmount(String.valueOf(totalCost));
            obj.setTradeDesc(tradeDescription);
            obj.setItemName(tradeDescription);
            obj.setReturnURL(orderPaymentReturnURL);
//            obj.setReturnURL("http://211.23.128.214:5000");
            obj.setNeedExtraPaidInfo("N");
            obj.setClientBackURL(orderPaymentClickBackURL);
            obj.setClientRedirectURL(orderPaymentClickBackURL);
//            obj.setClientBackURL("http://tw.yahoo.com");

            return obj;
        }

        return null;
    }

    public boolean submitOrderCallback(HttpServletRequest request) {
        String merchantTradeNo = request.getParameter("MerchantTradeNo");
        String rtnCode = request.getParameter("RtnCode");
        String rtnMsg = request.getParameter("RtnMsg");
        String simulatePaid = request.getParameter("SimulatePaid");
        String CheckMacValue = request.getParameter("CheckMacValue");

        logger.trace("merchantTradeNo = ["+merchantTradeNo+"]");
        logger.trace("rtnCode = ["+rtnCode+"]");
        logger.trace("rtnMsg = ["+rtnMsg+"]");
        logger.trace("simulatePaid = ["+simulatePaid+"]");
        logger.trace("CheckMacValue = ["+CheckMacValue+"]");

        ExProductOrder exProductOrder = exProductOrderService.findByID(merchantTradeNo);
        if(exProductOrder != null) {
            exProductOrder.setStatus(OrderStatus.FINISHED.name());
            exProductOrderService.save(exProductOrder);
            return true;
        }

        return false;
    }

    public ListHistoryOrderResponse listHistoryOrder(String authorization) {
        ListHistoryOrderResponse listHistoryOrderResponse = new ListHistoryOrderResponse();
        List<HistoryOrder> historyOrders  = new ArrayList();

        String account = tokenService.getUsernameFromToken(authorization);
        List<ExProductOrder> exProductOrders = exProductOrderService.listHistoryOrder(account);
        exProductOrders.forEach(exProductOrder -> {
            HistoryOrder historyOrder = new HistoryOrder();
            historyOrder.setOrderId(exProductOrder.getOrderId());
            historyOrder.setOrderDate(dateService.toDateString(exProductOrder.getOrderDate(),"yyyy-MM-dd HH:mm:ss"));
            historyOrder.setStatus(exProductOrder.getStatus());
            historyOrder.setTotalCost(new BigDecimal(exProductOrder.getCost()));
            historyOrder.setTotalPoint(new BigDecimal(exProductOrder.getPoint()));

            historyOrders.add(historyOrder);
        });

        listHistoryOrderResponse.setBody(historyOrders);
        return listHistoryOrderResponse;
    }
}
