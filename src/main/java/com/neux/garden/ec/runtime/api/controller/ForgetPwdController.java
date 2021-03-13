
/*
 * <p> Source File Name: ForgetPwd.java </p>
 * <p> Modify Date:  </p>
 */

package com.neux.garden.ec.runtime.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neux.garden.ec.runtime.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import com.neux.garden.ec.runtime.api.exception.APIException;
import com.neux.garden.ec.runtime.api.exception.NoSupportContentTypeException;
import com.neux.garden.ec.runtime.api.exception.UnknowException;
import com.neux.garden.ec.runtime.api.model.*;

@RestController
public class ForgetPwdController {

    private static final Logger logger = LoggerFactory.getLogger(ForgetPwdController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/ForgetPwd",
            produces = { "application/json" },
            method = RequestMethod.POST)
    @ResponseBody
    @Validated
    public GenerationResponse forgetPassword(@Valid @RequestBody ForgetPwdRequest forgetPwdRequest) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return accountService.forgetPassword(forgetPwdRequest);
            }
            catch(APIException e) {
                logger.error("forgetPassword APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
}
