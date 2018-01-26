package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private int id;
    private String name;
    private Dept dept;
    private String description;
    private Date createTime;

    public Post() {
    }

    public Post(int id, String name, Dept dept, String description, Date createTime) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.description = description;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
