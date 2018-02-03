package com.zf.dao;

import com.zf.model.Attendance;

import java.util.List;

public interface AttendanceMapper {
    boolean add(Attendance attendance);
    boolean update(Attendance attendance);
    Attendance queryByTodayEmployeeId(String today, int employeeId);
    Attendance queryById(int id);
    List<Attendance> queryByMonth(int month);
}
