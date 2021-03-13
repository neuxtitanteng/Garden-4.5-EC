
/*
 * <p> Source File Name: SubmitOrderRequest.java </p>
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
public class SubmitOrderRequest {

    
    @JsonProperty("SubmitTime")
    @Valid 
    private String submitTime = null;
            
    @JsonProperty("Datas")
    @Valid 
    private List<SubmitOrder> datas = new ArrayList<>();
            
    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }
            
    public void setDatas(List<SubmitOrder> datas) {
        this.datas = datas;
    }

    public List<SubmitOrder> getDatas() {
        return datas;
    }

    public void addDatas(SubmitOrder datas) {
        this.datas.add(datas);
    }
            

}
