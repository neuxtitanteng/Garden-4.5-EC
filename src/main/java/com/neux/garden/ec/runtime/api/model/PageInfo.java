
/*
 * <p> Source File Name: PageInfo.java </p>
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
public class PageInfo {

    
    @JsonProperty("TotalRec")

    @Valid 
    private BigDecimal totalRec = null;
            
    @JsonProperty("TotalPage")

    @Valid 
    private BigDecimal totalPage = null;
            
    @JsonProperty("PageNo")

    @Valid 
    private BigDecimal pageNo = null;
            
    public void setTotalRec(BigDecimal totalRec) {
        this.totalRec = totalRec;
    }

    public BigDecimal getTotalRec() {
        return totalRec;
    }
            
    public void setTotalPage(BigDecimal totalPage) {
        this.totalPage = totalPage;
    }

    public BigDecimal getTotalPage() {
        return totalPage;
    }
            
    public void setPageNo(BigDecimal pageNo) {
        this.pageNo = pageNo;
    }

    public BigDecimal getPageNo() {
        return pageNo;
    }
            

}
