package com.zf.service.impl;

import com.zf.dao.RewAndPunMapper;
import com.zf.model.RewAndPun;
import com.zf.service.RewAndPunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RewAndPunServiceImpl implements RewAndPunService{
    @Resource
    private RewAndPunMapper rewAndPunMapper;

    @Override
    public boolean add(RewAndPun rewAndPun) {
        return rewAndPunMapper.add(rewAndPun);
    }

    @Override
    public boolean update(RewAndPun rewAndPun) {
        return rewAndPunMapper.update(rewAndPun);
    }

    @Override
    public RewAndPun queryByET(int employeeId, String time) {
        return rewAndPunMapper.queryByET(employeeId,time);
    }
}
