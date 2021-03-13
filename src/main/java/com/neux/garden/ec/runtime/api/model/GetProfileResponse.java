
/*
 * <p> Source File Name: GetProductResponse.java </p>
 * <p> Modify Date: Sat Mar 13 17:05:24 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public class GetProfileResponse implements APIModel{

    
    @JsonProperty("Header")
    @Valid @NotNull
    private ResponseHeader header = null;
            
    @JsonProperty("Body")
    @Valid @NotNull
    private Profile body = null;
            
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public ResponseHeader getHeader() {
        return header;
    }
            
    public void setBody(Profile body) {
        this.body = body;
    }

    public Profile getBody() {
        return body;
    }
            

}
