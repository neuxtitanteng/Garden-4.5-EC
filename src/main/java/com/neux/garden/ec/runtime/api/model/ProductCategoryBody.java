
/*
 * <p> Source File Name: ProductCategoryBody.java </p>
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
public class ProductCategoryBody {

    
    @JsonProperty("ProductCategoryBody")
    @Valid @NotNull
    private List<ProductCategory> productCategoryBody = new ArrayList<>();
            
    public void setProductCategoryBody(List<ProductCategory> productCategoryBody) {
        this.productCategoryBody = productCategoryBody;
    }

    public List<ProductCategory> getProductCategoryBody() {
        return productCategoryBody;
    }

    public void addProductCategoryBody(ProductCategory productCategoryBody) {
        this.productCategoryBody.add(productCategoryBody);
    }
            

}
