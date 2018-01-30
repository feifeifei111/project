package com.zf.service;

import com.zf.model.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);
    boolean delete(int id);
    Dept queryById(int id);
    List<Dept> queryAll();
}
