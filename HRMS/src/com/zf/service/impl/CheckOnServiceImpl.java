package com.zf.service.impl;

import com.zf.dao.CheckOnMapper;
import com.zf.model.CheckOn;
import com.zf.service.CheckOnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckOnServiceImpl implements CheckOnService {
    @Resource
    private CheckOnMapper checkOnMapper;

    @Override
    public boolean add(CheckOn checkOn) {
        return checkOnMapper.add(checkOn);
    }

    @Override
    public boolean update(CheckOn checkOn) {
        return checkOnMapper.update(checkOn);
    }

    @Override
    public CheckOn queryByToday(String today) {
        return checkOnMapper.queryByToday(today);
    }
}
