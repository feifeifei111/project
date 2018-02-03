package com.zf.controller;

import com.zf.model.Attendance;
import com.zf.model.Employee;
import com.zf.model.RewAndPun;
import com.zf.model.Salary;
import com.zf.service.AttendanceService;
import com.zf.service.EmployeeService;
import com.zf.service.RewAndPunService;
import com.zf.service.SalaryService;
import com.zf.util.DoPaging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class EmployController {
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private RewAndPunService rewAndPunService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/signIn")
    public String signIn(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Employee employee=employeeService.queryById(employeeId);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month=calendar.get(Calendar.MONTH)+1;
        int days=calendar.getActualMaximum(Calendar.DATE);
        double everydaySalary=employee.getBasicSalary()/days;

        Attendance attendance =new Attendance();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 09:00";
        Date date1=sdf.parse(time);
        String t=sdf1.format(date);

        attendance.setBeginTime(date);
        if (date.getTime()-date1.getTime()>10800000){
            attendance.setBeginState(3);//旷工
            RewAndPun rewAndPun=new RewAndPun();
            rewAndPun.setMoney(-everydaySalary);
            rewAndPun.setTime(t);
            rewAndPun.setYear(year);
            rewAndPun.setMonth(month);
            rewAndPun.setCause("旷工");
            rewAndPun.setEmployeeId(employeeId);
            rewAndPunService.add(rewAndPun);
        }else if (date.getTime()-date1.getTime()>0){
            attendance.setBeginState(2);//迟到
            RewAndPun rewAndPun=new RewAndPun();
            rewAndPun.setMoney(-50);
            rewAndPun.setTime(t);
            rewAndPun.setYear(year);
            rewAndPun.setMonth(month);
            rewAndPun.setCause("迟到");
            rewAndPun.setEmployeeId(employeeId);
            rewAndPunService.add(rewAndPun);
        }else {
            attendance.setBeginState(1);//正常打卡
        }
        attendance.setToday(sdf1.format(date));
        attendance.setYear(year);
        attendance.setMonth(month);
        attendance.setEmployeeId(employeeId);
        attendanceService.add(attendance);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/signOut")
    public String signOut(int attendId,HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Employee employee=employeeService.queryById(employeeId);
        Attendance attendance = attendanceService.queryById(attendId);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int days=calendar.getActualMaximum(Calendar.DATE);
        double everydaySalary=employee.getBasicSalary()/days;

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 17:00";
        Date date1=sdf.parse(time);
        String t=sdf1.format(date);
        attendance.setEndTime(date);

        RewAndPun rewAndPun=rewAndPunService.queryByET(employeeId,t);
        if (date1.getTime()-date.getTime()>10800000){
            if (rewAndPun==null){
                RewAndPun rewAndPun1=new RewAndPun();
                rewAndPun1.setMoney(-everydaySalary);
                rewAndPun1.setTime(t);
                rewAndPun1.setYear(year);
                rewAndPun1.setMonth(month);
                rewAndPun1.setCause("旷工");
                rewAndPun1.setEmployeeId(employeeId);
                rewAndPunService.add(rewAndPun1);
            }else {
                if (rewAndPun.getMoney()!=-everydaySalary){
                    rewAndPun.setCause("旷工");
                    rewAndPun.setMoney(-everydaySalary);
                    rewAndPunService.update(rewAndPun);
                }
            }
            attendance.setEndState(3);//旷工
        }else if (date1.getTime()-date.getTime()>0){
            if (rewAndPun==null){
                RewAndPun rewAndPun1=new RewAndPun();
                rewAndPun1.setMoney(-50);
                rewAndPun1.setTime(t);
                rewAndPun1.setYear(year);
                rewAndPun1.setMonth(month);
                rewAndPun1.setCause("早退");
                rewAndPun1.setEmployeeId(employeeId);
                rewAndPunService.add(rewAndPun1);
            }else {
                if (rewAndPun.getMoney()==-50){
                    RewAndPun rewAndPun1=new RewAndPun();
                    rewAndPun1.setMoney(-50);
                    rewAndPun1.setTime(t);
                    rewAndPun1.setYear(year);
                    rewAndPun1.setMonth(month);
                    rewAndPun1.setCause("早退");
                    rewAndPun1.setEmployeeId(employeeId);
                    rewAndPunService.add(rewAndPun1);
                }
            }
            attendance.setEndState(2);//早退
        }else {
            attendance.setEndState(1);//正常打卡
        }
        attendanceService.update(attendance);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/selectAttendance")
    public String selectAttendance(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;

        List<Attendance> attendanceList=attendanceService.queryByYM(year,month,employeeId);//得到所有要显示的数据
        int totalRows = attendanceList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,0,pageSize);
        session.setAttribute("attendances",attendances);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthAttendance";
    }
    @RequestMapping("/showAttendance")
    public String showAttendance(int currentPage,HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        int pageSize=10;
        int currentRow=(currentPage-1)*pageSize;
        List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,currentRow,pageSize);
        session.setAttribute("attendances",attendances);
        return "employee/currentMonthAttendance";
    }
    @RequestMapping("/before")
    public String before(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        if (month==1){
            year-=1;
            month=12;
            List<Attendance> attendanceList=attendanceService.queryByYM(year,month,employeeId);//得到所有要显示的数据
            if (attendanceList.size()==0){
                return "employee/currentMonthAttendance";
            }
            int totalRows = attendanceList.size();//得到总行数
            int pageSize=10;
            int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
            List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,0,pageSize);
            session.setAttribute("attendances",attendances);
            session.setAttribute("totalPages",totalPages);
            session.setAttribute("year",year);
            session.setAttribute("month",month);
            return "employee/currentMonthAttendance";
        }
        List<Attendance> attendanceList=attendanceService.queryByYM(year,month,employeeId);//得到所有要显示的数据
        if (attendanceList.size()==0){
            return "employee/currentMonthAttendance";
        }
        int totalRows = attendanceList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,0,pageSize);
        session.setAttribute("attendances",attendances);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthAttendance";
    }
    @RequestMapping("/after")
    public String after(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        if (month==12){
            year+=1;
            month=1;
            List<Attendance> attendanceList=attendanceService.queryByYM(year,month,employeeId);//得到所有要显示的数据
            if (attendanceList.size()==0){
                return "employee/currentMonthAttendance";
            }
            int totalRows = attendanceList.size();//得到总行数
            int pageSize=10;
            int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
            List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,0,pageSize);
            session.setAttribute("attendances",attendances);
            session.setAttribute("totalPages",totalPages);
            session.setAttribute("year",year);
            session.setAttribute("month",month);
            return "employee/currentMonthAttendance";
        }
        List<Attendance> attendanceList=attendanceService.queryByYM(year,month,employeeId);//得到所有要显示的数据
        if (attendanceList.size()==0){
            return "employee/currentMonthAttendance";
        }
        int totalRows = attendanceList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Attendance> attendances = attendanceService.queryPageByYM(year,month,employeeId,0,pageSize);
        session.setAttribute("attendances",attendances);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthAttendance";
    }
}
