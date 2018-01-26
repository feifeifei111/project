package com.zf.model;

import java.io.Serializable;

public class Train implements Serializable {
    private int id;
    private String beginTime;
    private String endTime;
    private String name;
    private String content;
    private int state;
    private Employee employee;

    public Train() {
    }

    public Train(int id, String beginTime, String endTime, String name, String content, int state, Employee employee) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.name = name;
        this.content = content;
        this.state = state;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
