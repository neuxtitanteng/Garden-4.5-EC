
/*
 * <p> Source File Name: ExProductCategoryMappingIdentity.java </p>
 * <p> Modify Date: Sat Mar 20 15:19:45 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductCategoryMappingIdentity implements Serializable{
    
    @Column(name = "product_id")
    private String productId = null;
            
    @Column(name = "category_id")
    private String categoryId = null;
            
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
            
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
            
}
