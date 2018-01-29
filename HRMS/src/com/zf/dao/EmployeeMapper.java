package com.zf.dao;

import com.zf.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    boolean add(Employee employee);
    boolean update(Employee employee);
    Employee queryById(int id);
    Employee queryByUserId(int userId);
    List<Employee> queryByPostId(int postId);
}
