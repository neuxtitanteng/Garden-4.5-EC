
/*
 * <p> Source File Name: ListProductBody.java </p>
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
public class ListProductBody {

    
    @JsonProperty("PageInfo")
    @Valid 
    private PageInfo pageInfo = null;
            
    @JsonProperty("Datas")
    @Valid 
    private List<Product> datas = new ArrayList<>();
            
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }
            
    public void setDatas(List<Product> datas) {
        this.datas = datas;
    }

    public List<Product> getDatas() {
        return datas;
    }

    public void addDatas(Product datas) {
        this.datas.add(datas);
    }
            

}
