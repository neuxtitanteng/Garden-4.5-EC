
/*
 * <p> Source File Name: MgmActiveRecType.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mgm_active_rec_type")
public class MgmActiveRecType {

    @EmbeddedId
    private MgmActiveRecTypeIdentity identity = null;

  
    @Column(name = "type_name")
    private String typeName = null;
              
    @Column(name = "limit_amount")
    private Integer limitAmount = null;
              
    @Column(name = "current_amount")
    private Integer currentAmount = null;
              
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
              

    public void setIdentity(MgmActiveRecTypeIdentity identity) {
        this.identity = identity;
    }

    public MgmActiveRecTypeIdentity getIdentity() {
        return this.identity;
    }

    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
            	
    public void setLimitAmount(Integer limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Integer getLimitAmount() {
        return limitAmount;
    }
            	
    public void setCurrentAmount(Integer currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getCurrentAmount() {
        return currentAmount;
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
