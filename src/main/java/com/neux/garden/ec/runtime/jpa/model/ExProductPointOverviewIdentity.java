
/*
 * <p> Source File Name: ExProductPointOverviewIdentity.java </p>
 * <p> Modify Date: Sat Mar 20 16:40:03 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ExProductPointOverviewIdentity implements Serializable{

    @Column(name = "point_id")
    private String pointId = null;

    @Column(name = "product_id")
    private String productId = null;

    @Column(name = "category_id")
    private String categoryId = null;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

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
