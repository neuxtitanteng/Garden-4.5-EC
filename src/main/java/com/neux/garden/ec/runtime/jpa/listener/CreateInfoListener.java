package com.neux.garden.ec.runtime.jpa.listener;


import com.neux.garden.ec.runtime.jpa.model.BasicCreateUpdateInfo;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/4/5
 * Time: 下午 5:26
 * To change this template use File | Settings | File Templates.
 */
public class CreateInfoListener {

    @PrePersist
    public void onCreate(BasicCreateUpdateInfo info) {
        info.setCreateBy("SYSTEM");
        info.setCreateTime(new Date(new Date().getTime()));

        info.setUpdateBy("SYSTEM");
        info.setUpdateTime(new Date(new Date().getTime()));
    }

    @PreUpdate
    public void onUpdate(BasicCreateUpdateInfo info) {
        info.setUpdateTime(new Date(new Date().getTime()));
    }

}
