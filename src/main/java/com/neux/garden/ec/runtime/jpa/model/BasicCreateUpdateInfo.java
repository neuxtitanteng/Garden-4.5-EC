package com.neux.garden.ec.runtime.jpa.model;

import com.neux.garden.ec.runtime.jpa.listener.CreateInfoListener;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/4/5
 * Time: 下午 5:27
 * To change this template use File | Settings | File Templates.
 */
@EntityListeners(CreateInfoListener.class)
@MappedSuperclass
public class BasicCreateUpdateInfo {
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
