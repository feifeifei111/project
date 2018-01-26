package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class RewAndPun implements Serializable {
    private int id;
    private double money;
    private Date time;
    private String cause;
    private Employee employee;

    public RewAndPun() {
    }

    public RewAndPun(int id, double money, Date time, String cause, Employee employee) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.cause = cause;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "RewAndPun{" +
                "id=" + id +
                ", money=" + money +
                ", time=" + time +
                ", cause='" + cause + '\'' +
                ", employee=" + employee +
                '}';
    }
}
