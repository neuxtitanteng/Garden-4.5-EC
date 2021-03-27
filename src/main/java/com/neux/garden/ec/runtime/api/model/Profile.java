
/*
 * <p> Source File Name: Profile.java </p>
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
public class Profile {

    
    @JsonProperty("Password")
    @Valid @NotNull
    private String password = null;
            
    @JsonProperty("Name")
    @Valid
    private String name = null;
            
    @JsonProperty("Birthday")
    @Valid 
    private String birthday = null;
            
    @JsonProperty("Email")
    @Valid
    private String email = null;
            
    @JsonProperty("Mobile")
    @Valid 
    private String mobile = null;
            
    @JsonProperty("Phone")
    @Valid 
    private String phone = null;

    @JsonProperty("Address")
    @Valid
    private AddressInfo address = null;

    @JsonProperty("Point")
    @Valid @NotNull
    private Integer point = null;

            
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
            
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
            
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }
            
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
            
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
            
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
            
    public void setAddress(AddressInfo address) {
        this.address = address;
    }

    public AddressInfo getAddress() {
        return address;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
