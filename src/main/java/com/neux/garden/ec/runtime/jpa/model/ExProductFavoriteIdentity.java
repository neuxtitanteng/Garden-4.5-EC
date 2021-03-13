
/*
 * <p> Source File Name: ExProductFavoriteIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductFavoriteIdentity implements Serializable{
    
    @Column(name = "product_id")
    private String productId = null;
            
    @Column(name = "account")
    private String account = null;
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
            
}
