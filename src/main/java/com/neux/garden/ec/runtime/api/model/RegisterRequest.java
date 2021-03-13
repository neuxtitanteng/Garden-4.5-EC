
/*
 * <p> Source File Name: RegisterRequest.java </p>
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
public class RegisterRequest {

    
    @JsonProperty("Username")
    @Valid @NotNull
    private String username = null;
            
    @JsonProperty("Password")
    @Valid @NotNull
    private String password = null;
            
    @JsonProperty("Name")
    @Valid 
    private String name = null;
            
    @JsonProperty("Birthday")
    @Valid 
    private String birthday = null;
            
    @JsonProperty("ValidCode")
    @Valid @NotNull
    private String validCode = null;
            
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
            
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
            
    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }
            

}
