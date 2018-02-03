package com.zf.dao;

import com.zf.model.Salary;

public interface SalaryMapper {
    boolean add(Salary salary);
    boolean update(Salary salary);
    Salary queryEYM(int employeeId,int year,int month);
}
