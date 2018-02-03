package com.zf.controller;

import com.zf.model.Attendance;
import com.zf.service.AttendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class EmployController {
    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("/signIn")
    public String signIn(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Attendance attendance =new Attendance();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 09:00";
        Date date1=sdf.parse(time);
        attendance.setBeginTime(date);
        if (date.getTime()-date1.getTime()>10800000){
            attendance.setBeginState(3);//旷工
        }else if (date.getTime()-date1.getTime()>0){
            attendance.setBeginState(2);//迟到
        }else {
            attendance.setBeginState(1);//正常打卡
        }
        attendance.setToday(sdf1.format(date));
        Calendar calendar=Calendar.getInstance();
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month=calendar.get(Calendar.MONTH)+1;
        attendance.setMonth(month);
        attendance.setEmployeeId(employeeId);
        attendanceService.add(attendance);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/signOut")
    public String signOut(int attendId)throws Exception{
        Attendance attendance = attendanceService.queryById(attendId);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 17:00";
        Date date1=sdf.parse(time);
        attendance.setEndTime(date);
        if (date1.getTime()-date.getTime()>10800000){
            attendance.setEndState(3);//旷工
        }else if (date1.getTime()-date.getTime()>0){
            attendance.setEndState(2);//早退
        }else {
            attendance.setEndState(1);//正常打卡
        }
        attendanceService.update(attendance);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/selectAttendance")
    public String selectAttendance(int attendId)throws Exception{

        return "employee/employeeSuccess";
    }
}
