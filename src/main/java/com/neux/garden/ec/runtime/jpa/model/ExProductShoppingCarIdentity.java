
/*
 * <p> Source File Name: ExProductShoppingCarIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductShoppingCarIdentity implements Serializable{
    
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
