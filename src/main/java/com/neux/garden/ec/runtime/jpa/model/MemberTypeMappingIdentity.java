
/*
 * <p> Source File Name: MemberTypeMappingIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MemberTypeMappingIdentity implements Serializable{
    
    @Column(name = "account")
    private String account = null;
            
    @Column(name = "type_id")
    private String typeId = null;
            
    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
            
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }
            
}
