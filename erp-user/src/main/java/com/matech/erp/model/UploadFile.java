package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_upload_file")
public class UploadFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "save_name")
    private String saveName;

    private String path;

    private Integer size;

    private String md5;

    @Column(name = "create_by")
    private Integer createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_by")
    private Integer updateBy;

    @Column(name = "update_time")
    private Date updateTime;

    private String deleted;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return original_name
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * @param originalName
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * @return save_name
     */
    public String getSaveName() {
        return saveName;
    }

    /**
     * @param saveName
     */
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * @return create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_by
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}