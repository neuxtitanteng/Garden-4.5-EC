
/*
 * <p> Source File Name: LoginBody.java </p>
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
public class LoginBody {

    
    @JsonProperty("Success")
    @Valid 
    private Boolean success = false;
            
    @JsonProperty("Token")
    @Valid 
    private String token = null;
            
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }
            
    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
            

}
