
/*
 * <p> Source File Name: ExProductOrder.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_order")
public class ExProductOrder {
  
    @Id
    @Column(name = "order_id")
    private String orderId = null;
          
    @Column(name = "account")
    private String account = null;
          
    @Column(name = "status")
    private String status = null;
          
    @Column(name = "payment_type")
    private String paymentType = null;
          
    @Column(name = "point")
    private Integer point = null;
          
    @Column(name = "cost")
    private Integer cost = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate = null;
          
    @Column(name = "order_year")
    private Integer orderYear = null;
          
    @Column(name = "order_quarter")
    private Integer orderQuarter = null;
          
    @Column(name = "order_month")
    private Integer orderMonth = null;
          
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
          
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
            
    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
            
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
            
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
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
            
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }
            
    public void setOrderYear(Integer orderYear) {
        this.orderYear = orderYear;
    }

    public Integer getOrderYear() {
        return orderYear;
    }
            
    public void setOrderQuarter(Integer orderQuarter) {
        this.orderQuarter = orderQuarter;
    }

    public Integer getOrderQuarter() {
        return orderQuarter;
    }
            
    public void setOrderMonth(Integer orderMonth) {
        this.orderMonth = orderMonth;
    }

    public Integer getOrderMonth() {
        return orderMonth;
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
