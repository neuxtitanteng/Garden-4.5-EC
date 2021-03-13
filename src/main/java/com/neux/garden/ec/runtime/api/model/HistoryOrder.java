
/*
 * <p> Source File Name: HistoryOrder.java </p>
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
public class HistoryOrder {

    
    @JsonProperty("OrderId")
    @Valid 
    private String orderId = null;
            
    @JsonProperty("OrderDate")
    @Valid 
    private String orderDate = null;
            
    @JsonProperty("Status")
    @Valid 
    private String status = null;
            
    @JsonProperty("TotalPoint")

    @Valid 
    private BigDecimal totalPoint = null;
            
    @JsonProperty("TotalCost")

    @Valid 
    private BigDecimal totalCost = null;
            
    @JsonProperty("Details")
    @Valid 
    private String details = null;
            
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
            
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }
            
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
            
    public void setTotalPoint(BigDecimal totalPoint) {
        this.totalPoint = totalPoint;
    }

    public BigDecimal getTotalPoint() {
        return totalPoint;
    }
            
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
            
    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
            

}
