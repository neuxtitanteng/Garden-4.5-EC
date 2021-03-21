
/*
 * <p> Source File Name: ListShoppingCarResponse.java </p>
 * <p> Modify Date: Sat Mar 13 17:05:23 CST 2021 </p>
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
public class ListShoppingCarResponse implements APIModel{

    
    @JsonProperty("Header")
    @Valid 
    private ResponseHeader header = null;
            
    @JsonProperty("Body")
    @Valid 
    private ArrayList<Product> body = new ArrayList<>();
            
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void addProduct(Product product) {
        body.add(product);
    }

    public ArrayList<Product> getBody() {
        return body;
    }

    public void setBody(ArrayList<Product> body) {
        this.body = body;
    }
}
