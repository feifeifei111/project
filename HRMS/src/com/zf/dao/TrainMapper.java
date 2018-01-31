package com.zf.dao;

import com.zf.model.Train;

import java.util.List;

public interface TrainMapper {
    boolean add(Train train);
    boolean delete(int id);
    boolean update(Train train);
    Train queryById(int id);
    List<Train> queryExist();
}
