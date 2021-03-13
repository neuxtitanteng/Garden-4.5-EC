
/*
 * <p> Source File Name: MgmActiveRecTypeIdentity.java </p>
 * <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MgmActiveRecTypeIdentity implements Serializable{
    
    @Column(name = "active_id")
    private String activeId = null;
            
    @Column(name = "type_id")
    private String typeId = null;
            
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveId() {
        return activeId;
    }
            
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }
            
}
