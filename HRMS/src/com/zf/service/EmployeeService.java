package com.zf.service;

import com.zf.model.Employee;

import java.util.List;

public interface EmployeeService {
    boolean add(Employee employee);
    boolean update(Employee employee);
    Employee queryById(int id);
    Employee queryByUserId(int userId);
    List<Employee> queryByPostId(int postId);
    List<Employee> queryPage(int postId,int currentRow,int pageSize);
    List<Employee> queryByLikeName(String name);
}
