package com.zf.service.impl;

import com.zf.dao.EmployeeMapper;
import com.zf.model.Employee;
import com.zf.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean add(Employee employee) {
        return employeeMapper.add(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public Employee queryById(int id) {
        return employeeMapper.queryById(id);
    }

    @Override
    public Employee queryByUserId(int userId) {
        return employeeMapper.queryByUserId(userId);
    }
}
