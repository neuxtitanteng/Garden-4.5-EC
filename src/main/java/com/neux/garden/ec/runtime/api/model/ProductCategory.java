
/*
 * <p> Source File Name: ProductCategory.java </p>
 * <p> Modify Date: Sat Mar 13 17:05:24 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

@Validated
public class ProductCategory {

    
    @JsonProperty("CategoryId")
    @Valid @NotNull
    private String categoryId = null;
            
    @JsonProperty("CategoryName")
    @Valid @NotNull
    private String categoryName = null;
            
    @JsonProperty("Description")
    @Valid 
    private String description = null;
            
    @JsonProperty("ParentId")
    @Valid 
    private String parentId = null;
            
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return categoryId;
    }
            
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
            
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
            
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }
            

}
