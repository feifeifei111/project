package com.zf.service;

import com.zf.model.Attendance;

import java.util.List;

public interface AttendanceService {
    boolean add(Attendance attendance);
    boolean update(Attendance attendance);
    Attendance queryByTodayEmployeeId(String today, int employeeId);
    Attendance queryById(int id);
    List<Attendance> queryByYM(int year,int month,int employeeId);
    List<Attendance> queryPageByYM(int year,int month,int employeeId,int currentRow,int pageSize);
}
