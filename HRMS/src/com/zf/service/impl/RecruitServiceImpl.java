package com.zf.service.impl;

import com.zf.dao.RecruitMapper;
import com.zf.model.Recruit;
import com.zf.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService{
    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public boolean add(Recruit recruit) {
        return recruitMapper.add(recruit);
    }

    @Override
    public boolean delete(int id) {
        return recruitMapper.delete(id);
    }

    @Override
    public boolean update(Recruit recruit) {
        return recruitMapper.update(recruit);
    }

    @Override
    public Recruit queryById(int id) {
        return recruitMapper.queryById(id);
    }

    @Override
    public List<Recruit> queryAll() {
        return recruitMapper.queryAll();
    }

    @Override
    public List<Recruit> queryPage(int currentRow, int pageSize) {
        return recruitMapper.queryPage(currentRow,pageSize);
    }
}
