package com.zf.service;

import com.zf.model.Train;

import java.util.List;

public interface TrainService {
    boolean add(Train train);
    boolean update(Train train);
    Train queryById(int id);
    List<Train> queryExist();
}
