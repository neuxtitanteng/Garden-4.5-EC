
/*
 * <p> Source File Name: Member.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="member")
public class Member extends BasicCreateUpdateInfo {
  
    @Id
    @Column(name = "account")
    private String account = null;
          
    @Column(name = "password")
    private String password = null;
          
    @Column(name = "name")
    private String name = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthday")
    private Date birthday = null;
          
    @Column(name = "email")
    private String email = null;
          
    @Column(name = "phone")
    private String phone = null;
          
    @Column(name = "mobile")
    private String mobile = null;
          
    @Column(name = "city_id")
    private String cityId = null;
          
    @Column(name = "zipcode")
    private String zipcode = null;
          
    @Column(name = "address")
    private String address = null;
          
    @Column(name = "is_open")
    private String isOpen = null;

    @Column(name = "point")
    private Integer point = null;


    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
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
            
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }
            
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
            
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
            
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
            
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
            
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
