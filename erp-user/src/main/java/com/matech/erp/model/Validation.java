package com.matech.erp.model;

import javax.persistence.*;

@Table(name = "sys_validation")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 字段名
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 字段约束
     */
    private String constraint;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 约束描述
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
     * @return table_name - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取字段名
     *
     * @return field_name - 字段名
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名
     *
     * @param fieldName 字段名
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取字段约束
     *
     * @return constraint - 字段约束
     */
    public String getConstraint() {
        return constraint;
    }

    /**
     * 设置字段约束
     *
     * @param constraint 字段约束
     */
    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    /**
     * 获取提示信息
     *
     * @return message - 提示信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置提示信息
     *
     * @param message 提示信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取约束描述
     *
     * @return description - 约束描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置约束描述
     *
     * @param description 约束描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}