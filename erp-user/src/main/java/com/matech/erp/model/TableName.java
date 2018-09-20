package com.matech.erp.model;

import javax.persistence.*;

@Table(name = "sys_table_name")
public class TableName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 表名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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
     * 获取表名
     *
     * @return name - 表名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置表名
     *
     * @param name 表名
     */
    public void setName(String name) {
        this.name = name;
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
}