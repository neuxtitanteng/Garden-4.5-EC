package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.api.model.*;
import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductLog;
import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverview;
import com.neux.garden.ec.runtime.service.data.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService<T> {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ExProductCategoryService exProductCategoryService;

    @Autowired
    private ExProductService exProductService;

    @Autowired
    private ExProductLogService exProductLogService;

    @Autowired
    private ExProductPointOverviewService exProductPointOverviewService;

    public ProductCategoryResponse listProductCategory() {

        ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse();
        ProductCategoryBody productCategoryBody = new ProductCategoryBody();

        exProductCategoryService.findAll().forEach(exProductCategory -> {
            ProductCategory productCategory = new ProductCategory();

            productCategory.setCategoryId(exProductCategory.getCategoryId());
            productCategory.setCategoryName(exProductCategory.getCategoryName());
            productCategory.setDescription(exProductCategory.getDescription());
            productCategory.setParentId(exProductCategory.getParentId());

            productCategoryBody.addProductCategoryBody(productCategory);
        });

        productCategoryResponse.setBody(productCategoryBody);
        return productCategoryResponse;
    }

    public ListProductResponse listProduct(String categoryId,String keyword,String productId,String minPoint,String maxPoint,String pageNo){
        ListProductResponse listProductResponse = new ListProductResponse();
        ListProductBody listProductBody = new ListProductBody();

        int page = StringUtils.isNumeric(pageNo) ? Integer.parseInt(pageNo) : 1;

        Page<ExProduct> exProducts = exProductService.listProducts(categoryId,keyword,productId,minPoint,maxPoint,page);
        if(exProducts != null) {
            exProducts.forEach(exProduct -> listProductBody.addDatas(convertAPIProduct(exProduct)));
        }

        PageInfo pageInfo = new PageInfo();

        pageInfo.setPageNo(new BigDecimal(page));
        pageInfo.setTotalPage(new BigDecimal(exProducts != null ? exProducts.getTotalElements() : 0));
        pageInfo.setTotalRec(new BigDecimal(exProducts != null ? exProducts.getTotalPages() : 0));

        listProductBody.setPageInfo(pageInfo);
        listProductResponse.setBody(listProductBody);

        return listProductResponse;
    }

    public GetProductResponse getProduct(String productId) {

        GetProductResponse response = new GetProductResponse();

        ExProduct exProduct = exProductService.findByProductId(productId);

        response.setBody(convertAPIProduct(exProduct));

        return response;
    }

    private Product convertAPIProduct(ExProduct exProduct) {

        String productId = exProduct.getProductId();

        List<ExProductPointOverview> overviews = exProductPointOverviewService.findByProductId(productId);
        ExProductLog exProductLog = exProductLogService.findByID(productId);

        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(exProduct.getProductName());
        product.setDescription(exProduct.getDescription());
        product.setIntroduction(exProduct.getIntroduction().toString()); //TODO
        product.setPicture(""); //TODO
        product.setStatus(exProduct.getStockStatus());
        product.setStock(new BigDecimal(exProduct.getStock()));
        product.setViewCount(new BigDecimal(exProductLog == null ? 0 : (exProductLog.getViewCount() == null ? 0 : exProductLog.getViewCount())));
        product.setOrderCount(new BigDecimal(exProductLog == null ? 0 : (exProductLog.getOrderCount() == null ? 0 : exProductLog.getOrderCount())));

        overviews.forEach(exProductPointOverview -> {
            ProductExchange productExchange = new ProductExchange();

            productExchange.setPointCategoryType(exProductPointOverview.getIdentity().getCategoryId());
            productExchange.setPointCategoryName(exProductPointOverview.getCategoryName());
            productExchange.setPoint(new BigDecimal(exProductPointOverview.getPoint()));
            productExchange.setCost(new BigDecimal(exProductPointOverview.getExtraCost()));

            product.addProductExchanges(productExchange);
        });


        return product;
    }
}
