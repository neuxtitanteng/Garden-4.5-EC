
/*
 * <p> Source File Name: Product.java </p>
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
public class Product {

    
    @JsonProperty("ProductId")
    @Valid @NotNull
    private String productId = null;
            
    @JsonProperty("ProductName")
    @Valid @NotNull
    private String productName = null;
            
    @JsonProperty("Picture")
    @Valid @NotNull
    private String picture = null;
            
    @JsonProperty("Status")
    @Valid @NotNull
    private String status = null;
            
    @JsonProperty("Stock")

    @Valid @NotNull
    private BigDecimal stock = null;
            
    @JsonProperty("Description")
    @Valid @NotNull
    private String description = null;
            
    @JsonProperty("Introduction")
    @Valid 
    private String introduction = null;
            
    @JsonProperty("ViewCount")

    @Valid 
    private BigDecimal viewCount = null;
            
    @JsonProperty("OrderCount")

    @Valid 
    private BigDecimal orderCount = null;
            
    @JsonProperty("ProductExchanges")
    @Valid 
    private List<ProductExchange> productExchanges = new ArrayList<>();
            
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
            
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }
            
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
            
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getStock() {
        return stock;
    }
            
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
            
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }
            
    public void setViewCount(BigDecimal viewCount) {
        this.viewCount = viewCount;
    }

    public BigDecimal getViewCount() {
        return viewCount;
    }
            
    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }
            
    public void setProductExchanges(List<ProductExchange> productExchanges) {
        this.productExchanges = productExchanges;
    }

    public List<ProductExchange> getProductExchanges() {
        return productExchanges;
    }

    public void addProductExchanges(ProductExchange productExchanges) {
        this.productExchanges.add(productExchanges);
    }
            

}
