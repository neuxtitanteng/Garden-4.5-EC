
/*
 * <p> Source File Name: ExProductPointOverview.java </p>
 * <p> Modify Date: Sat Mar 20 16:40:03 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_point_overview")
public class ExProductPointOverview {

    @EmbeddedId
    private ExProductPointOverviewIdentity identity = null;

    @Column(name = "category_name")
    private String categoryName = null;
              
    @Column(name = "point")
    private Integer point = null;
              
    @Column(name = "extra_cost")
    private Integer extraCost = null;
              
    @Column(name = "orders")
    private Integer orders = null;
              

    public void setIdentity(ExProductPointOverviewIdentity identity) {
        this.identity = identity;
    }

    public ExProductPointOverviewIdentity getIdentity() {
        return this.identity;
    }

            	
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
            	
    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }
            	
    public void setExtraCost(Integer extraCost) {
        this.extraCost = extraCost;
    }

    public Integer getExtraCost() {
        return extraCost;
    }
            	
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getOrders() {
        return orders;
    }
            	

}
