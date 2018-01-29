package com.zf.dao;

import com.zf.model.Employee;

public interface EmployeeMapper {
    boolean add(Employee employee);
    boolean update(Employee employee);
    Employee queryById(int id);
    Employee queryByUserId(int userId);
}
