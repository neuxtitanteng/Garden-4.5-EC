
/*
 * <p> Source File Name: ResponseHeader.java </p>
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
public class ResponseHeader {

    
    @JsonProperty("RequestTime")
    @Valid @NotNull
    private String requestTime = null;
            
    @JsonProperty("ResponseTime")
    @Valid @NotNull
    private String responseTime = null;
            
    @JsonProperty("ResponseCode")
    @Valid @NotNull
    private String responseCode = "0";
            
    @JsonProperty("ErrorMsg")
    @Valid 
    private String errorMsg = null;
            
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestTime() {
        return requestTime;
    }
            
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseTime() {
        return responseTime;
    }
            
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }
            
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
            

}
