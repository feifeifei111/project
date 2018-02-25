package com.zf.model;

import java.io.Serializable;

public class Dissent implements Serializable {
    private int id;
    private String reason;
    private double money;
    private int year;
    private int month;
    private int employeeId;
    private int salaryId;
    private int state;

    public Dissent() {
    }

    public Dissent(int id, String reason, double money, int year, int month, int employeeId, int salaryId, int state) {
        this.id = id;
        this.reason = reason;
        this.money = money;
        this.year = year;
        this.month = month;
        this.employeeId = employeeId;
        this.salaryId = salaryId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Dissent{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", money=" + money +
                ", year=" + year +
                ", month=" + month +
                ", employeeId=" + employeeId +
                ", salaryId=" + salaryId +
                ", state=" + state +
                '}';
    }
}
