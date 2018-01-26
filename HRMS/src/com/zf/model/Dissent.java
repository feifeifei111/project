package com.zf.model;

import java.io.Serializable;

public class Dissent implements Serializable {
    private int id;
    private String reason;
    private int month;
    private Employee employee;
    private Salary salary;
    private int state;

    public Dissent() {
    }

    public Dissent(int id, String reason, int month, Employee employee, Salary salary, int state) {
        this.id = id;
        this.reason = reason;
        this.month = month;
        this.employee = employee;
        this.salary = salary;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
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
                ", month=" + month +
                ", employee=" + employee +
                ", salary=" + salary +
                ", state=" + state +
                '}';
    }
}
