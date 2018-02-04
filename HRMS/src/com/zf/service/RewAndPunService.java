package com.zf.service;

import com.zf.model.RewAndPun;

import java.util.List;

public interface RewAndPunService {
    boolean add(RewAndPun rewAndPun);
    boolean update(RewAndPun rewAndPun);
    RewAndPun queryByET(int employeeId,String time);
    List<RewAndPun> queryByEYM(int employeeId, int year, int month);
    List<RewAndPun> queryPageByEYM(int employeeId,int year,int month,int currentRow,int pageSize);
}
