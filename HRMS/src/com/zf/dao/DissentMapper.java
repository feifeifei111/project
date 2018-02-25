package com.zf.dao;

import com.zf.model.Dissent;

import java.util.List;

public interface DissentMapper {
    boolean add(Dissent dissent);
    boolean update(Dissent dissent);
    Dissent queryById(int id);
    List<Dissent> queryByEmployId(int employeeId);
}
