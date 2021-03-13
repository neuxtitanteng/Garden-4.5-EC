
/*
 * <p> Source File Name: ExProductCategoryPileIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductCategoryPileIdentity implements Serializable{
    
    @Column(name = "category_id")
    private String categoryId = null;
            
    @Column(name = "sub_category_id")
    private String subCategoryId = null;
            
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
            
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }
            
}
