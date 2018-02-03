package com.zf.service;

import com.zf.model.Salary;

public interface SalaryService {
    boolean add(Salary salary);
    boolean update(Salary salary);
    Salary queryEYM(int employeeId,int year,int month);
}
