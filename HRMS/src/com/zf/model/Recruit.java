package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Recruit implements Serializable{
    private int id;
    private Post post;
    private String description;
    private String address;
    private int state;
    private Date createTime;

    public Recruit() {
    }

    public Recruit(int id, Post post, String description, String address, int state, Date createTime) {
        this.id = id;
        this.post = post;
        this.description = description;
        this.address = address;
        this.state = state;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", post=" + post+
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
