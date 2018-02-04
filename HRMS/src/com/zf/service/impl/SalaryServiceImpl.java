package com.zf.service.impl;

import com.zf.dao.SalaryMapper;
import com.zf.model.Salary;
import com.zf.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Salary> queryByEmployeeId(int employeeId) {
        return salaryMapper.queryByEmployeeId(employeeId);
    }

    @Override
    public List<Salary> queryPageByEmployeeId(int employeeId, int currentRow, int pageSize) {
        return salaryMapper.queryPageByEmployeeId(employeeId,currentRow,pageSize);
    }

    @Override
    public List<Salary> queryByYM(int year, int month) {
        return salaryMapper.queryByYM(year,month);
    }
}
