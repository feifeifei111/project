package com.zf.service;

import com.zf.model.Dissent;

import java.util.List;

public interface DissentService {
    boolean add(Dissent dissent);
    boolean update(Dissent dissent);
    Dissent queryById(int id);
    List<Dissent> queryByEmployId(int employeeId);
}
