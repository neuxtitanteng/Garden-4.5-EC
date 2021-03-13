
/*
 * <p> Source File Name: ForgetPwdRequest.java </p>
 * <p> Modify Date: Sat Mar 13 17:05:24 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

@Validated
public class ForgetPwdRequest {

    
    @JsonProperty("Email")
    @Valid @NotNull
    private String email = null;
            
    @JsonProperty("ValidCode")
    @Valid @NotNull
    private String validCode = null;
            
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
            
    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }
            

}
