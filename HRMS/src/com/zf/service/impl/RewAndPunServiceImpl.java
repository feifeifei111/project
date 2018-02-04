package com.zf.service.impl;

import com.zf.dao.RewAndPunMapper;
import com.zf.model.RewAndPun;
import com.zf.service.RewAndPunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<RewAndPun> queryByEYM(int employeeId, int year, int month) {
        return rewAndPunMapper.queryByEYM(employeeId,year,month);
    }

    @Override
    public List<RewAndPun> queryPageByEYM(int employeeId, int year, int month, int currentRow, int pageSize) {
        return rewAndPunMapper.queryPageByEYM(employeeId,year,month,currentRow,pageSize);
    }
}
