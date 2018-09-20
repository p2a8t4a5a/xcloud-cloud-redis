package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission")
public class Permission {
    /**
     * 授权ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 授权名称
     */
    private String name;

    /**
     * 资源类型
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 操作类型
     */
    @Column(name = "operation_id")
    private Integer operationId;

    /**
     * 权限描述
     */
    private String description;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_time")
    private Date updateTime;

    private String deleted;

    /**
     * 获取授权ID
     *
     * @return id - 授权ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置授权ID
     *
     * @param id 授权ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取授权名称
     *
     * @return name - 授权名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置授权名称
     *
     * @param name 授权名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取资源类型
     *
     * @return resource_id - 资源类型
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源类型
     *
     * @param resourceId 资源类型
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取操作类型
     *
     * @return operation_id - 操作类型
     */
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * 设置操作类型
     *
     * @param operationId 操作类型
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    /**
     * 获取权限描述
     *
     * @return description - 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
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
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
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