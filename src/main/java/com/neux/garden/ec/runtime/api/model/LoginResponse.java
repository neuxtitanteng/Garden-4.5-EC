
/*
 * <p> Source File Name: LoginResponse.java </p>
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
public class LoginResponse implements APIModel{

    
    @JsonProperty("Header")
    @Valid @NotNull
    private ResponseHeader header = null;
            
    @JsonProperty("Body")
    @Valid @NotNull
    private LoginBody body = null;
            
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public ResponseHeader getHeader() {
        return header;
    }
            
    public void setBody(LoginBody body) {
        this.body = body;
    }

    public LoginBody getBody() {
        return body;
    }
            

}
