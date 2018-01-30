package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Recruit implements Serializable{
    private int id;
    private int postId;
    private String requirement;
    private String salaryRange;
    private String introduction;
    private String address;
    private Date createTime;

    public Recruit() {
    }

    public Recruit(int id, int postId, String requirement, String salaryRange, String introduction, String address, Date createTime) {
        this.id = id;
        this.postId = postId;
        this.requirement = requirement;
        this.salaryRange = salaryRange;
        this.introduction = introduction;
        this.address = address;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                ", postId=" + postId +
                ", requirement='" + requirement + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", introduction='" + introduction + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
