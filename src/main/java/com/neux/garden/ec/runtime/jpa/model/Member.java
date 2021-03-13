
/*
 * <p> Source File Name: Member.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="member")
public class Member {
  
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
    private Integer cityId = null;
          
    @Column(name = "zipcode")
    private Integer zipcode = null;
          
    @Column(name = "address")
    private String address = null;
          
    @Column(name = "is_open")
    private String isOpen = null;
          
    @Column(name = "create_by")
    private String createBy = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime = null;
          
    @Column(name = "update_by")
    private String updateBy = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime = null;
          
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
            
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCityId() {
        return cityId;
    }
            
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getZipcode() {
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
            
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return createBy;
    }
            
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
            
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }
            
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
            

}
