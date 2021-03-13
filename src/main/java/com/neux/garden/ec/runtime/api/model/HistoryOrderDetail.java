
/*
 * <p> Source File Name: HistoryOrderDetail.java </p>
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
public class HistoryOrderDetail {

    
    @JsonProperty("ProductId")
    @Valid 
    private String productId = null;
            
    @JsonProperty("ProductName")
    @Valid 
    private String productName = null;
            
    @JsonProperty("PointCategoryName")
    @Valid 
    private String pointCategoryName = null;
            
    @JsonProperty("Quantity")

    @Valid 
    private BigDecimal quantity = null;
            
    @JsonProperty("Point")

    @Valid 
    private BigDecimal point = null;
            
    @JsonProperty("Cost")

    @Valid 
    private BigDecimal cost = null;
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
            
    public void setPointCategoryName(String pointCategoryName) {
        this.pointCategoryName = pointCategoryName;
    }

    public String getPointCategoryName() {
        return pointCategoryName;
    }
            
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
            
    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getPoint() {
        return point;
    }
            
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
            

}
