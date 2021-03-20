
/*
 * <p> Source File Name: ExProductCategoryMapping.java </p>
 * <p> Modify Date: Sat Mar 20 15:19:45 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ex_product_category_mapping")
public class ExProductCategoryMapping {

    @EmbeddedId
    private ExProductCategoryMappingIdentity identity = null;

  

    public void setIdentity(ExProductCategoryMappingIdentity identity) {
        this.identity = identity;
    }

    public ExProductCategoryMappingIdentity getIdentity() {
        return this.identity;
    }

    

}
