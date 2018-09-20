package com.matech.erp.model;

import javax.persistence.*;

@Table(name = "sys_resource")
public class Resource {
    /**
     * 资源ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称(菜单,按钮)
     */
    private String name;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源表
     */
    private String table;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 获取资源ID
     *
     * @return id - 资源ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资源ID
     *
     * @param id 资源ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名称(菜单,按钮)
     *
     * @return name - 资源名称(菜单,按钮)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称(菜单,按钮)
     *
     * @param name 资源名称(菜单,按钮)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取资源类型
     *
     * @return type - 资源类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置资源类型
     *
     * @param type 资源类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取资源编码
     *
     * @return code - 资源编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置资源编码
     *
     * @param code 资源编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取资源表
     *
     * @return table - 资源表
     */
    public String getTable() {
        return table;
    }

    /**
     * 设置资源表
     *
     * @param table 资源表
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * 获取资源描述
     *
     * @return description - 资源描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置资源描述
     *
     * @param description 资源描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}