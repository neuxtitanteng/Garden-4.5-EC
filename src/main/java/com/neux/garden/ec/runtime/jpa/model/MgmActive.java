
/*
 * <p> Source File Name: MgmActive.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mgm_active")
public class MgmActive {
  
    @Id
    @Column(name = "active_id")
    private String activeId = null;
          
    @Column(name = "active_name")
    private String activeName = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime = null;
          
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime = null;
          
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
          
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveId() {
        return activeId;
    }
            
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public String getActiveName() {
        return activeName;
    }
            
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }
            
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
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
