package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dict")
public class Dict {
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
     * 字典项名称
     */
    private String name;

    /**
     * 字典项枚举名
     */
    private String code;

    /**
     * 字典项枚举值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private Byte type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
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
     * 获取字典项名称
     *
     * @return name - 字典项名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字典项名称
     *
     * @param name 字典项名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取字典项枚举名
     *
     * @return code - 字典项枚举名
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置字典项枚举名
     *
     * @param code 字典项枚举名
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取字典项枚举值
     *
     * @return value - 字典项枚举值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置字典项枚举值
     *
     * @param value 字典项枚举值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取标签名
     *
     * @return label - 标签名
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置标签名
     *
     * @param label 标签名
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取排序（升序）
     *
     * @return sort_order - 排序（升序）
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序（升序）
     *
     * @param sortOrder 排序（升序）
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