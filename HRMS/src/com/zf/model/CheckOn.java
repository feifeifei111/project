package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class CheckOn implements Serializable {
    private int id;
    private Date beginTime;
    private Date endTime;
    private int beginState;
    private int endState;
    private Employee employee;

    public CheckOn() {
    }

    public CheckOn(int id, Date beginTime, Date endTime, int beginState, int endState, Employee employee) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.beginState = beginState;
        this.endState = endState;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getBeginState() {
        return beginState;
    }

    public void setBeginState(int beginState) {
        this.beginState = beginState;
    }

    public int getEndState() {
        return endState;
    }

    public void setEndState(int endState) {
        this.endState = endState;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "CheckOn{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", beginState=" + beginState +
                ", endState=" + endState +
                ", employee=" + employee +
                '}';
    }
}
