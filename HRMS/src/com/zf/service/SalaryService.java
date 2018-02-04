package com.zf.service;

import com.zf.model.Salary;

import java.util.List;

public interface SalaryService {
    boolean add(Salary salary);
    boolean update(Salary salary);
    List<Salary> queryByEmployeeId(int employeeId);
    List<Salary> queryPageByEmployeeId(int employeeId,int currentRow,int pageSize);
    List<Salary> queryByYM(int year, int month);
}
