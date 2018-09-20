package com.matech.erp.model;

import javax.persistence.*;

@Table(name = "sys_operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作名称(读,写,删除,列表)
     */
    private String name;

    /**
     * 操作编码
     */
    private String code;

    /**
     * 操作描述
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
     * 获取操作名称(读,写,删除,列表)
     *
     * @return name - 操作名称(读,写,删除,列表)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置操作名称(读,写,删除,列表)
     *
     * @param name 操作名称(读,写,删除,列表)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取操作编码
     *
     * @return code - 操作编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置操作编码
     *
     * @param code 操作编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取操作描述
     *
     * @return description - 操作描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置操作描述
     *
     * @param description 操作描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}