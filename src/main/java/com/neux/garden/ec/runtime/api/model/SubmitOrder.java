
/*
 * <p> Source File Name: SubmitOrder.java </p>
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
public class SubmitOrder {

    
    @JsonProperty("ProductId")
    @Valid 
    private String productId = null;
            
    @JsonProperty("PointType")
    @Valid 
    private String pointType = null;
            
    @JsonProperty("Quantity")

    @Valid 
    private BigDecimal quantity = null;
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getPointType() {
        return pointType;
    }
            
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
            

}
