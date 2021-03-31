package com.neux.garden.ec.runtime.api.controller;

import com.neux.garden.ec.runtime.api.exception.APIException;
import com.neux.garden.ec.runtime.api.exception.UnknowException;
import com.neux.garden.ec.runtime.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderCallbackController {

    private Logger logger = LoggerFactory.getLogger(OrderCallbackController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/OrderCallback", method = RequestMethod.POST)
    @ResponseBody
    public String orderCallback() {

        try{
            return orderService.submitOrderCallback(request) ? "1|OK" : "";
        }
        catch(APIException e) {
            logger.error("orderCallback APIException !!",e);
            throw e;
        }catch(Exception e) {
            logger.error("Unknow Exception !!",e);
            throw new UnknowException(e);
        }
    }
}
