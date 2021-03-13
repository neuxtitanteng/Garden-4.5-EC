
/*
 * <p> Source File Name: ListHistoryOrderResponse.java </p>
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
public class ListHistoryOrderResponse {

    
    @JsonProperty("Header")
    @Valid 
    private ResponseHeader header = null;
            
    @JsonProperty("Body")
    @Valid 
    private String body = null;
            
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public ResponseHeader getHeader() {
        return header;
    }
            
    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
            

}
