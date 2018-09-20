package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_module")
public class Module {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 所有父级编号
     */
    private String path;

    /**
     * 备注信息
     */
    private String description;

    private String code;

    /**
     * 链接
     */
    private String href;

    /**
     * 目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 禁止，启用
     */
    private Boolean status;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记
     */
    private String deleted;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所有父级编号
     *
     * @return path - 所有父级编号
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置所有父级编号
     *
     * @param path 所有父级编号
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取备注信息
     *
     * @return description - 备注信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置备注信息
     *
     * @param description 备注信息
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取链接
     *
     * @return href - 链接
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置链接
     *
     * @param href 链接
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 获取目标
     *
     * @return target - 目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置目标
     *
     * @param target 目标
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取禁止，启用
     *
     * @return status - 禁止，启用
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置禁止，启用
     *
     * @param status 禁止，启用
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取权限标识
     *
     * @return permission - 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     *
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标记
     *
     * @return deleted - 删除标记
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 设置删除标记
     *
     * @param deleted 删除标记
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}