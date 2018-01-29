package com.zf.service;

import com.zf.model.Recruit;

import java.util.List;

public interface RecruitService {
    boolean add(Recruit recruit);
    Recruit queryById(int id);
    List<Recruit> queryAll();
    List<Recruit> queryPage(int currentRow, int pageSize);
}
