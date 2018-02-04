package com.zf.dao;

import com.zf.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    boolean add(Employee employee);
    boolean update(Employee employee);
    Employee queryById(int id);
    Employee queryByUserId(int userId);
    List<Employee> queryByPostId(int postId);
    List<Employee> queryPage(int postId,int currentRow,int pageSize);
    List<Employee> queryByLikeName(String name);
    List<Employee> queryByTrainId(int trainId);
    List<Employee> queryAll();
}
