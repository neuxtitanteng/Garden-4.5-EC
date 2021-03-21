
/*
 * <p> Source File Name: Favorite.java </p>
 * <p> Modify Date:  </p>
 */

package com.neux.garden.ec.runtime.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neux.garden.ec.runtime.service.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import com.neux.garden.ec.runtime.api.exception.APIException;
import com.neux.garden.ec.runtime.api.exception.NoSupportContentTypeException;
import com.neux.garden.ec.runtime.api.exception.UnknowException;
import com.neux.garden.ec.runtime.api.model.*;

@RestController
public class FavoriteController {

    private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ShoppingService shoppingService;


    @RequestMapping(value = "/Favorite",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public ListShoppingCarResponse listFavorite(@Valid @RequestHeader(value = "Authorization", required = true) String authorization) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return shoppingService.listMyFavorite(authorization);
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

    @RequestMapping(value = "/Favorite/{productId}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    @ResponseBody
    @Validated
    public GenerationResponse addFavorite(@Valid @RequestHeader(value = "Authorization", required = true) String authorization ,
                                            @Valid @PathVariable("productId") String productId) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return shoppingService.addFavorite(authorization,productId);
            }
            catch(APIException e) {
                logger.error("addFavorite APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
}
