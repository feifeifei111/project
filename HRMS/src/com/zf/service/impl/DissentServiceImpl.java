package com.zf.service.impl;

import com.zf.dao.DissentMapper;
import com.zf.model.Dissent;
import com.zf.service.DissentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DissentServiceImpl implements DissentService{
    @Resource
    private DissentMapper dissentMapper;

    @Override
    public boolean add(Dissent dissent) {
        return dissentMapper.add(dissent);
    }

    @Override
    public boolean update(Dissent dissent) {
        return dissentMapper.update(dissent);
    }

    @Override
    public Dissent queryById(int id) {
        return dissentMapper.queryById(id);
    }

    @Override
    public List<Dissent> queryByEmployId(int employeeId) {
        return dissentMapper.queryByEmployId(employeeId);
    }
}
