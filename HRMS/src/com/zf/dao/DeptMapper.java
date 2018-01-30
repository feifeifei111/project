package com.zf.dao;

import com.zf.model.Dept;

import java.util.List;

public interface DeptMapper {
    boolean add(Dept dept);
    boolean delete(int id);
    Dept queryById(int id);
    List<Dept> queryAll();
}
