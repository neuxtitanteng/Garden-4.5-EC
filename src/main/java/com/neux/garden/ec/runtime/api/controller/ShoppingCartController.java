
/*
 * <p> Source File Name: ShoppingCar.java </p>
 * <p> Modify Date:  </p>
 */

package com.neux.garden.ec.runtime.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neux.garden.ec.runtime.api.exception.APIException;
import com.neux.garden.ec.runtime.api.exception.NoSupportContentTypeException;
import com.neux.garden.ec.runtime.api.exception.UnknowException;
import com.neux.garden.ec.runtime.api.model.GenerationResponse;
import com.neux.garden.ec.runtime.api.model.ListShoppingCarResponse;
import com.neux.garden.ec.runtime.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class ShoppingCartController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(value = "/ShoppingCart",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public ListShoppingCarResponse listShoppingCar(@Valid @RequestHeader(value = "Authorization", required = true) String authorization) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return shoppingService.listShoppingCart(authorization);
            }
            catch(APIException e) {
                logger.error("listFavorite APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }

    @RequestMapping(value = "/ShoppingCart/{productId}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    @ResponseBody
    @Validated
    public GenerationResponse addShoppingCart(@Valid @RequestHeader(value = "Authorization", required = true) String authorization ,
                                          @Valid @PathVariable("productId") String productId) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return shoppingService.addShoppingCart(authorization,productId);
            }
            catch(APIException e) {
                logger.error("addShoppingCart APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
    
}
