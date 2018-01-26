package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int id;
    private int state;
    private Post post;
    private User user;
    private Train train;
    private Date createTime;

    public Employee() {
    }

    public Employee(int id, int state, Post post, User user, Train train, Date createTime) {
        this.id = id;
        this.state = state;
        this.post = post;
        this.user = user;
        this.train = train;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
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
                ", post=" + post +
                ", user=" + user +
                ", train=" + train +
                ", createTime=" + createTime +
                '}';
    }
}
