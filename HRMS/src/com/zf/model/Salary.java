package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {
    private int id;
    private double basic;
    private double bonus;
    private double social;
    private double rewAndPun;
    private int year;
    private int month;
    private int employeeId;

    public Salary() {
    }

    public Salary(int id, double basic, double bonus, double social, double rewAndPun, int year,int month, int employeeId) {
        this.id = id;
        this.basic = basic;
        this.bonus = bonus;
        this.social = social;
        this.rewAndPun = rewAndPun;
        this.year = year;
        this.month = month;
        this.employeeId = employeeId;
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
        return "Salary{" +
                "id=" + id +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", social=" + social +
                ", rewAndPun=" + rewAndPun +
                ", year=" + year +
                ", month=" + month +
                ", employeeId=" + employeeId +
                '}';
    }
}
