
/*
 * <p> Source File Name: MgmActivePromoCode.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mgm_active_promo_code")
public class MgmActivePromoCode {

    @EmbeddedId
    private MgmActivePromoCodeIdentity identity = null;

  
    @Column(name = "promo_code")
    private String promoCode = null;
              
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
              

    public void setIdentity(MgmActivePromoCodeIdentity identity) {
        this.identity = identity;
    }

    public MgmActivePromoCodeIdentity getIdentity() {
        return this.identity;
    }

    
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoCode() {
        return promoCode;
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
