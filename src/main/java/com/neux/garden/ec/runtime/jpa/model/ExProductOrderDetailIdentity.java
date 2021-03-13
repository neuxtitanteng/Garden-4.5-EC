
/*
 * <p> Source File Name: ExProductOrderDetailIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductOrderDetailIdentity implements Serializable{
    
    @Column(name = "order_id")
    private String orderId = null;
            
    @Column(name = "product_id")
    private String productId = null;
            
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
}
