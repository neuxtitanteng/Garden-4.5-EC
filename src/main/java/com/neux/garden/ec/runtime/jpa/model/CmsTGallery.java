
/*
 * <p> Source File Name: CmsTGallery.java </p>
 * <p> Modify Date: Fri May 08 09:21:54 CST 2020 </p>
 */

package com.neux.garden.ec.runtime.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cms_t_gallery")
@Getter
@Setter
public class CmsTGallery  {
  
    @Id
    @Column(name = "gallery_id")
    private Integer galleryId = null;

    @Column(name = "file_name")
    private String fileName = null;
          
    @Column(name = "rename_name")
    private String renameName = null;
          
    @Column(name = "size")
    private Integer size = null;
          
    @Column(name = "file_type")
    private String fileType = null;

    @Column(name = "description")
    private String description = null;

    @Column(name = "gallery_type")
    private String galleryType = null;

    @Column(name = "original_gallery_id")
    private Integer originalGalleryId = null;

    @Column(name = "setting")
    private String setting = null;
    
    @Column(name = "path")
    private String path = null;

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
}
