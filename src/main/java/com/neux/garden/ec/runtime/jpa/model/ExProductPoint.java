
/*
 * <p> Source File Name: ExProductPoint.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_point")
public class ExProductPoint {
  
    @Id
    @Column(name = "point_id")
    private String pointId = null;
          
    @Column(name = "category_id")
    private String categoryId = null;
          
    @Column(name = "product_id")
    private String productId = null;
          
    @Column(name = "point")
    private Integer point = null;
          
    @Column(name = "extra_cost")
    private Integer extraCost = null;
          
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
          
    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointId() {
        return pointId;
    }
            
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }
            
    public void setExtraCost(Integer extraCost) {
        this.extraCost = extraCost;
    }

    public Integer getExtraCost() {
        return extraCost;
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
