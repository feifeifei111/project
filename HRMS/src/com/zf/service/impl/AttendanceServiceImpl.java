package com.zf.service.impl;

import com.zf.dao.AttendanceMapper;
import com.zf.model.Attendance;
import com.zf.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public boolean add(Attendance attendance) {
        return attendanceMapper.add(attendance);
    }

    @Override
    public boolean update(Attendance attendance) {
        return attendanceMapper.update(attendance);
    }

    @Override
    public Attendance queryByTodayEmployeeId(String today, int employeeId) {
        return attendanceMapper.queryByTodayEmployeeId(today,employeeId);
    }

    @Override
    public Attendance queryById(int id) {
        return attendanceMapper.queryById(id);
    }

    @Override
    public List<Attendance> queryByMonth(int month) {
        return attendanceMapper.queryByMonth(month);
    }

}
