package com.zf.service;

import com.zf.model.RewAndPun;

public interface RewAndPunService {
    boolean add(RewAndPun rewAndPun);
    boolean update(RewAndPun rewAndPun);
    RewAndPun queryByET(int employeeId,String time);
}
