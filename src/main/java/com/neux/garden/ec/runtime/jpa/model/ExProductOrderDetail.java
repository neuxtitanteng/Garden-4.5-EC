
/*
 * <p> Source File Name: ExProductOrderDetail.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_order_detail")
public class ExProductOrderDetail {

    @EmbeddedId
    private ExProductOrderDetailIdentity identity = null;


    @Column(name = "product_name")
    private String productName = null;

    @Column(name = "point_category_name")
    private String pointCategoryName = null;
              
    @Column(name = "quantity")
    private Integer quantity = null;
              
    @Column(name = "point")
    private Integer point = null;
              
    @Column(name = "cost")
    private Integer cost = null;
              
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
              

    public void setIdentity(ExProductOrderDetailIdentity identity) {
        this.identity = identity;
    }

    public ExProductOrderDetailIdentity getIdentity() {
        return this.identity;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPointCategoryName() {
        return pointCategoryName;
    }

    public void setPointCategoryName(String pointCategoryName) {
        this.pointCategoryName = pointCategoryName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
            	
    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }
            	
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
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
