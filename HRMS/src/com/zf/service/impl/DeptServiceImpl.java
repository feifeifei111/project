package com.zf.service.impl;

import com.zf.dao.DeptMapper;
import com.zf.model.Dept;
import com.zf.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.add(dept);
    }

    @Override
    public boolean delete(int id) {
        return deptMapper.delete(id);
    }

    @Override
    public Dept queryById(int id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
