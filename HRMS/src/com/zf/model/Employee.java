package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int id;
    private int state;
    private int postId;
    private int userId;
    private int trainId;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, int state, int postId, int userId, int trainId, Date createTime) {
        this.id = id;
        this.state = state;
        this.postId = postId;
        this.userId = userId;
        this.trainId = trainId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", state=" + state +
                ", postId=" + postId +
                ", userId=" + userId +
                ", trainId=" + trainId +
                ", createTime=" + createTime +
                '}';
    }
}
