package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_area")
public class Area {
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
     * 备注信息
     */
    private String description;

    /**
     * 所有父级编号
     */
    private String path;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域类型
     */
    private Byte type;

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
     * 获取区域编码
     *
     * @return code - 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置区域编码
     *
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取区域类型
     *
     * @return type - 区域类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置区域类型
     *
     * @param type 区域类型
     */
    public void setType(Byte type) {
        this.type = type;
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