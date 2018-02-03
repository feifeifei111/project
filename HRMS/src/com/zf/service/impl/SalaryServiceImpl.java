package com.zf.service.impl;

import com.zf.dao.SalaryMapper;
import com.zf.model.Salary;
import com.zf.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalaryServiceImpl implements SalaryService{
    @Resource
    private SalaryMapper salaryMapper;

    @Override
    public boolean add(Salary salary) {
        return salaryMapper.add(salary);
    }

    @Override
    public boolean update(Salary salary) {
        return salaryMapper.update(salary);
    }

    @Override
    public Salary queryEYM(int employeeId, int year, int month) {
        return salaryMapper.queryEYM(employeeId,year,month);
    }
}
