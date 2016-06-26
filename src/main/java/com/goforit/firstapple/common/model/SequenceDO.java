package com.goforit.firstapple.common.model;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/24.
 */
public class SequenceDO {

    private long id;

    private String tableName;

    private Date createdTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
