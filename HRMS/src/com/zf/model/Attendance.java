package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private int id;
    private Date beginTime;
    private Date endTime;
    private int beginState;
    private int endState;
    private String today;
    private int year;
    private int month;
    private int employeeId;

    public Attendance() {
    }

    public Attendance(int id, Date beginTime, Date endTime, int beginState, int endState, String today, int year,int month, int employeeId) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.beginState = beginState;
        this.endState = endState;
        this.today=today;
        this.year=year;
        this.month=month;
        this.employeeId = employeeId;
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

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", beginState=" + beginState +
                ", endState=" + endState +
                ", today=" + today +
                ", year=" + year +
                ", month=" + month +
                ", employeeId=" + employeeId +
                '}';
    }
}
