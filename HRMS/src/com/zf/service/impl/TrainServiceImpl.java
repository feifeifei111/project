package com.zf.service.impl;

import com.zf.dao.TrainMapper;
import com.zf.model.Train;
import com.zf.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService{
    @Resource
    private TrainMapper trainMapper;

    @Override
    public boolean add(Train train) {
        return trainMapper.add(train);
    }

    @Override
    public boolean delete(int id) {
        return trainMapper.delete(id);
    }

    @Override
    public boolean update(Train train) {
        return trainMapper.update(train);
    }

    @Override
    public Train queryById(int id) {
        return trainMapper.queryById(id);
    }

    @Override
    public List<Train> queryExist() {
        return trainMapper.queryExist();
    }
}
