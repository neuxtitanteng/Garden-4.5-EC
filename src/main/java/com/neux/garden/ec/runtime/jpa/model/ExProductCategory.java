
/*
 * <p> Source File Name: ExProductCategory.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_category")
public class ExProductCategory {
  
    @Id
    @Column(name = "category_id")
    private String categoryId = null;
          
    @Column(name = "category_name")
    private String categoryName = null;
          
    @Column(name = "description")
    private String description = null;
          
    @Column(name = "parent_id")
    private String parentId = null;
          
    @Column(name = "is_open")
    private String isOpen = null;
          
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
            
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getIsOpen() {
        return isOpen;
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
