package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {
    private int id;
    private double basic;
    private double bonus;
    private double social;
    private double rewAndPun;
    private Date accountTime;
    private Employee employee;

    public Salary() {
    }

    public Salary(int id, double basic, double bonus, double social, double rewAndPun, Date accountTime, Employee employee) {
        this.id = id;
        this.basic = basic;
        this.bonus = bonus;
        this.social = social;
        this.rewAndPun = rewAndPun;
        this.accountTime = accountTime;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSocial() {
        return social;
    }

    public void setSocial(double social) {
        this.social = social;
    }

    public double getRewAndPun() {
        return rewAndPun;
    }

    public void setRewAndPun(double rewAndPun) {
        this.rewAndPun = rewAndPun;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", social=" + social +
                ", rewAndPun=" + rewAndPun +
                ", accountTime=" + accountTime +
                ", employee=" + employee +
                '}';
    }
}
