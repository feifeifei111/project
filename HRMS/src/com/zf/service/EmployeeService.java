package com.zf.service;

import com.zf.model.Employee;

public interface EmployeeService {
    boolean add(Employee employee);
    boolean update(Employee employee);
    Employee queryById(int id);
    Employee queryByUserId(int userId);
}
