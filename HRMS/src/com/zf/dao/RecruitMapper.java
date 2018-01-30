package com.zf.dao;

import com.zf.model.Recruit;

import java.util.List;

public interface RecruitMapper {
    boolean add(Recruit recruit);
    boolean delete(int id);
    boolean update(Recruit recruit);
    Recruit queryById(int id);
    List<Recruit> queryAll();
    List<Recruit> queryPage(int currentRow, int pageSize);
}
