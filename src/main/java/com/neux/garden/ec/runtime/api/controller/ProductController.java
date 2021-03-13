
/*
 * <p> Source File Name: Product.java </p>
 * <p> Modify Date:  </p>
 */

package com.neux.garden.ec.runtime.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    
    @RequestMapping(value = "/Product",
        produces = { "application/json" },
        
        method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public ListProductResponse listProduct(
        
        @Valid  @RequestParam(value="categoryId", required=false) String categoryId,
        @Valid  @RequestParam(value="keyword", required=false) String keyword,
        @Valid  @RequestParam(value="productId", required=false) String productId,
        @Valid  @RequestParam(value="minPoint", required=false) String minPoint,
        @Valid  @RequestParam(value="maxPoint", required=false) String maxPoint){

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return objectMapper.readValue("{\"Header\":{},\"Body\":{}}",ListProductResponse.class);
            }
            catch(APIException e) {
                logger.error("listProduct APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
    
    @RequestMapping(value = "/Product/{productId}",
        produces = { "application/json" },
        
        method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public GetProductResponse getProduct(
        
        @Valid  @RequestParam(value="productId", required=true) String productId){

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return objectMapper.readValue("{\"Header\":{},\"Body\":{}}",GetProductResponse.class);
            }
            catch(APIException e) {
                logger.error("getProduct APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
    
}
