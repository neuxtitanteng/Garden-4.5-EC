
/*
 * <p> Source File Name: ExProduct.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product")
public class ExProduct {
  
    @Id
    @Column(name = "product_id")
    private String productId = null;
          
    @Column(name = "product_name")
    private String productName = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture")
    private CmsTGallery picture = null;
          
    @Column(name = "stock_status")
    private String stockStatus = null;
          
    @Column(name = "stock")
    private Integer stock = null;

    @Column(name = "stock_current")
    private Integer stockCurrent = null;
          
    @Column(name = "stock_limit_percent")
    private Integer stockLimitPercent = null;

    @Column(name = "description")
    private String description = null;

    @Column(name = "introduction")
    private Integer introduction = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime = null;
          
    @Column(name = "create_by")
    private String createBy = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime = null;
          
    @Column(name = "update_by")
    private String updateBy = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime = null;
          
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

    public CmsTGallery getPicture() {
        return picture;
    }

    public void setPicture(CmsTGallery picture) {
        this.picture = picture;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getStockStatus() {
        return stockStatus;
    }
            
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getStockCurrent() {
        return stockCurrent;
    }

    public void setStockCurrent(Integer stockCurrent) {
        this.stockCurrent = stockCurrent;
    }

    public void setStockLimitPercent(Integer stockLimitPercent) {
        this.stockLimitPercent = stockLimitPercent;
    }

    public Integer getStockLimitPercent() {
        return stockLimitPercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Integer introduction) {
        this.introduction = introduction;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }
            
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }
            
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return createBy;
    }
            
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
            
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }
            
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
            

}
