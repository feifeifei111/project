package com.zf.dao;

import com.zf.model.RewAndPun;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RewAndPunMapper {
    boolean add(RewAndPun rewAndPun);
    boolean update(RewAndPun rewAndPun);
    RewAndPun queryByET(@Param("employeeId") int employeeId, @Param("time") String time);
    List<RewAndPun> queryByEYM(int employeeId,int year,int month);
    List<RewAndPun> queryPageByEYM(int employeeId,int year,int month,int currentRow,int pageSize);
}
