package com.matech.erp.model;

import javax.persistence.*;

@Table(name = "sys_user_contact")
public class UserContact {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 联系类型
     */
    private Integer type;

    /**
     * 联系号码
     */
    private String information;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取联系类型
     *
     * @return type - 联系类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置联系类型
     *
     * @param type 联系类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取联系号码
     *
     * @return information - 联系号码
     */
    public String getInformation() {
        return information;
    }

    /**
     * 设置联系号码
     *
     * @param information 联系号码
     */
    public void setInformation(String information) {
        this.information = information;
    }
}