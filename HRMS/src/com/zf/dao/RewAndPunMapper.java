package com.zf.dao;

import com.zf.model.RewAndPun;

public interface RewAndPunMapper {
    boolean add(RewAndPun rewAndPun);
    boolean update(RewAndPun rewAndPun);
    RewAndPun queryByET(int employeeId,String time);
}
