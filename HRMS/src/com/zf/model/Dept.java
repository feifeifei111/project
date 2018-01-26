package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable {
    private int id;
    private String name;
    private Date createTime;

    public Dept() {
    }

    public Dept(int id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
