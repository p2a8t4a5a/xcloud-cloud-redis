package com.matech.erp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_table_log")
public class TableLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "row_id")
    private Integer rowId;

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
     * @return table_id
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * @param tableId
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * @return row_id
     */
    public Integer getRowId() {
        return rowId;
    }

    /**
     * @param rowId
     */
    public void setRowId(Integer rowId) {
        this.rowId = rowId;
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