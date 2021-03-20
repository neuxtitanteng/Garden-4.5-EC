
/*
 * <p> Source File Name: ExProductLog.java </p>
 * <p> Modify Date: Sat Mar 20 16:13:38 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_log")
public class ExProductLog {
  
    @Id
    @Column(name = "product_id")
    private String productId = null;
          
    @Column(name = "view_count")
    private Integer viewCount = null;
          
    @Column(name = "order_count")
    private Integer orderCount = null;
          
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }
            
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }
            

}
