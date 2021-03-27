
/*
 * <p> Source File Name: Profile.java </p>
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
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/Profile",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public GetProfileResponse getProfile(@Valid @RequestHeader(value = "Authorization", required = true) String authorization) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return accountService.getProfile(authorization);
            }
            catch(APIException e) {
                logger.error("getProfile APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }

    @RequestMapping(value = "/Profile/{username}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @ResponseBody
    @Validated
    public GetProfileResponse getProfileByUsername(@Valid  @PathVariable(value="username", required=true) String username) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return accountService.getProfileByUsername(username);
            }
            catch(APIException e) {
                logger.error("getProfile APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }

    @RequestMapping(value = "/Profile",
            produces = { "application/json" },
            method = RequestMethod.POST)
    @ResponseBody
    @Validated
    public GenerationResponse updateProfile(@Valid @RequestHeader(value = "Authorization", required = true) String authorization , @Valid @RequestBody Profile profile) {

        String accept = request.getHeader("Content-Type");
        if (accept != null && accept.contains("application/json")) {
            try{
                return accountService.updateProfile(authorization,profile);
            }
            catch(APIException e) {
                logger.error("updateProfile APIException !!",e);
                throw e;
            }catch(Exception e) {
                logger.error("Unknow Exception !!",e);
                throw new UnknowException(e);
            }
        }
        else throw new NoSupportContentTypeException();

    }
}
