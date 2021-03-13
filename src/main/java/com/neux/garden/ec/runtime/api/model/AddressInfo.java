
/*
 * <p> Source File Name: AddressInfo.java </p>
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
public class AddressInfo {

    
    @JsonProperty("CityId")
    @Valid 
    private String cityId = null;
            
    @JsonProperty("Zipcode")
    @Valid 
    private String zipcode = null;
            
    @JsonProperty("Address")
    @Valid 
    private String address = null;
            
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }
            
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }
            
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
            

}
