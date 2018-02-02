package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class RewAndPun implements Serializable {
    private int id;
    private double money;
    private Date time;
    private String cause;
    private int employeeId;

    public RewAndPun() {
    }

    public RewAndPun(int id, double money, Date time, String cause, int employeeId) {
        this.id = id;
        this.money = money;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
                ", cause='" + cause + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
