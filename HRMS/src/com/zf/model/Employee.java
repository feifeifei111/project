package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private double basicSalary;
    private int state;
    private String cause;
    private int postId;
    private int userId;
    private int trainId;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, String name, String sex, String birthday, double basicSalary, int state, String cause, int postId, int userId, int trainId, Date createTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.basicSalary = basicSalary;
        this.state = state;
        this.cause = cause;
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

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
                ", basicSalary=" + basicSalary +
                ", state=" + state +
                ", cause='" + cause + '\'' +
                ", postId=" + postId +
                ", userId=" + userId +
                ", trainId=" + trainId +
                ", createTime=" + createTime +
                '}';
    }
}
