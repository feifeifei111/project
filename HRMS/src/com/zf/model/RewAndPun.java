package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class RewAndPun implements Serializable {
    private int id;
    private double money;
    private String time;
    private int year;
    private int month;
    private String cause;
    private int employeeId;

    public RewAndPun() {
    }

    public RewAndPun(int id, double money, String time,int year,int month, String cause, int employeeId) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.year = year;
        this.month = month;
        this.cause = cause;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "RewAndPun{" +
                "id=" + id +
                ", money=" + money +
                ", time=" + time +
                ", year=" + year +
                ", month=" + month +
                ", cause='" + cause + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
