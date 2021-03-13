
/*
 * <p> Source File Name: MgmActiveRec.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mgm_active_rec")
public class MgmActiveRec {

    @EmbeddedId
    private MgmActiveRecIdentity identity = null;

  
    @Column(name = "rec_id")
    private Integer recId = null;
              
    @Column(name = "promo_code")
    private String promoCode = null;
              
    @Column(name = "rec_account")
    private String recAccount = null;
              
    @Column(name = "amount")
    private Integer amount = null;
              
    @Column(name = "data_year")
    private Integer dataYear = null;
              
    @Column(name = "data_quarter")
    private Integer dataQuarter = null;
              
    @Column(name = "data_month")
    private Integer dataMonth = null;
              
    @Column(name = "data_date")
    private Integer dataDate = null;
              
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
              

    public void setIdentity(MgmActiveRecIdentity identity) {
        this.identity = identity;
    }

    public MgmActiveRecIdentity getIdentity() {
        return this.identity;
    }

    
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getRecId() {
        return recId;
    }
            	
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoCode() {
        return promoCode;
    }
            	
    public void setRecAccount(String recAccount) {
        this.recAccount = recAccount;
    }

    public String getRecAccount() {
        return recAccount;
    }
            	
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
            	
    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public Integer getDataYear() {
        return dataYear;
    }
            	
    public void setDataQuarter(Integer dataQuarter) {
        this.dataQuarter = dataQuarter;
    }

    public Integer getDataQuarter() {
        return dataQuarter;
    }
            	
    public void setDataMonth(Integer dataMonth) {
        this.dataMonth = dataMonth;
    }

    public Integer getDataMonth() {
        return dataMonth;
    }
            	
    public void setDataDate(Integer dataDate) {
        this.dataDate = dataDate;
    }

    public Integer getDataDate() {
        return dataDate;
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
