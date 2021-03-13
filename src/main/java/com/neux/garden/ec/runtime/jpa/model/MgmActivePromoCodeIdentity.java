
/*
 * <p> Source File Name: MgmActivePromoCodeIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MgmActivePromoCodeIdentity implements Serializable{
    
    @Column(name = "account")
    private String account = null;
            
    @Column(name = "active_id")
    private String activeId = null;
            
    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
            
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveId() {
        return activeId;
    }
            
}
