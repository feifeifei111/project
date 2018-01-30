package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private int state;
    private int postId;
    private int userId;
    private int trainId;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, String name, String sex, String birthday, int state, int postId, int userId, int trainId, Date createTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", state=" + state +
                ", postId=" + postId +
                ", userId=" + userId +
                ", trainId=" + trainId +
                ", createTime=" + createTime +
                '}';
    }
}
