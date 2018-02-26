package com.zf.controller;

import com.zf.model.*;
import com.zf.service.*;
import com.zf.util.DoPaging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    @Resource
    private SalaryService salaryService;
    @Resource
    private DissentService dissentService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private TrainService trainService;

    @RequestMapping("/signIn")
    public String signIn(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Employee employee=employeeService.queryById(employeeId);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month=calendar.get(Calendar.MONTH)+1;
//        int days=calendar.getActualMaximum(Calendar.DATE);获取当月天数
        double everydaySalary=employee.getBasicSalary()/22;//一个月的工作天数直接按22天算

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
            rewAndPun.setCause("Absenteeism");
            rewAndPun.setEmployeeId(employeeId);
            rewAndPunService.add(rewAndPun);
        }else if (date.getTime()-date1.getTime()>0){
            attendance.setBeginState(2);//迟到
            RewAndPun rewAndPun=new RewAndPun();
            rewAndPun.setMoney(-50);
            rewAndPun.setTime(t);
            rewAndPun.setYear(year);
            rewAndPun.setMonth(month);
            rewAndPun.setCause("Late");
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
        Attendance attend= attendanceService.queryByTodayEmployeeId(t,employee.getId());
        session.setAttribute("attend",attend);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/signOut")
    public String signOut(int attendId, HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Employee employee=employeeService.queryById(employeeId);
        Attendance attendance = attendanceService.queryById(attendId);
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        double everydaySalary=employee.getBasicSalary()/22;

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
                rewAndPun1.setCause("Absenteeism");
                rewAndPun1.setEmployeeId(employeeId);
                rewAndPunService.add(rewAndPun1);
            }else {
                if (rewAndPun.getMoney()!=-everydaySalary){
                    rewAndPun.setCause("Absenteeism");
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
                rewAndPun1.setCause("Leave early");
                rewAndPun1.setEmployeeId(employeeId);
                rewAndPunService.add(rewAndPun1);
            }else {
                if (rewAndPun.getMoney()==-50){
                    rewAndPun.setMoney(-100);
                    rewAndPun.setCause("Late+Leave early");
                    rewAndPunService.update(rewAndPun);
                }
            }
            attendance.setEndState(2);//早退
        }else {
            attendance.setEndState(1);//正常打卡
        }
        attendanceService.update(attendance);
        Attendance attend= attendanceService.queryByTodayEmployeeId(t,employee.getId());
        session.setAttribute("attend",attend);
        return "employee/employeeSuccess";
    }
    @RequestMapping("/employeeBack")
    public String employeeBack()throws Exception{
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
        }else {
            month-=1;
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
        }else {
            month+=1;
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
    @RequestMapping("/selectRewAndPun")
    public String selectRewAndPun(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;

        List<RewAndPun> rewAndPunList=rewAndPunService.queryByEYM(employeeId,year,month);//得到所有要显示的数据
        int totalRows = rewAndPunList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<RewAndPun> rewAndPuns = rewAndPunService.queryPageByEYM(employeeId,year,month,0,pageSize);
        session.setAttribute("rewAndPuns",rewAndPuns);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthRewAndPun";
    }
    @RequestMapping("/showRewAndPun")
    public String showRewAndPun(int currentPage,HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        int pageSize=10;
        int currentRow=(currentPage-1)*pageSize;
        List<RewAndPun> rewAndPuns = rewAndPunService.queryPageByEYM(employeeId,year,month,currentRow,pageSize);
        session.setAttribute("rewAndPuns",rewAndPuns);
        return "employee/currentMonthRewAndPun";
    }
    @RequestMapping("/beforeRP")
    public String beforeRP(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        if (month==1){
            year-=1;
            month=12;
        }else {
            month-=1;
        }
        List<RewAndPun> rewAndPunList=rewAndPunService.queryByEYM(employeeId,year,month);//得到所有要显示的数据
        if (rewAndPunList.size()==0){
            return "employee/currentMonthRewAndPun";
        }
        int totalRows = rewAndPunList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<RewAndPun> rewAndPuns = rewAndPunService.queryPageByEYM(employeeId,year,month,0,pageSize);
        session.setAttribute("rewAndPuns",rewAndPuns);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthRewAndPun";
    }
    @RequestMapping("/afterRP")
    public String afterRP(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        if (month==12){
            year+=1;
            month=1;
        }else {
            month+=1;
        }
        List<RewAndPun> rewAndPunList=rewAndPunService.queryByEYM(employeeId,year,month);//得到所有要显示的数据
        if (rewAndPunList.size()==0){
            return "employee/currentMonthRewAndPun";
        }
        int totalRows = rewAndPunList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<RewAndPun> rewAndPuns = rewAndPunService.queryPageByEYM(employeeId,year,month,0,pageSize);
        session.setAttribute("rewAndPuns",rewAndPuns);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        return "employee/currentMonthRewAndPun";
    }
    @RequestMapping("/selectSalary")
    public String selectSalary(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        List<Salary> salaryList=salaryService.queryByEmployeeId(employeeId);//得到所有要显示的数据
        int totalRows = salaryList.size();//得到总行数
        int pageSize=10;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Salary> salaries = salaryService.queryPageByEmployeeId(employeeId,0,pageSize);
        session.setAttribute("salaries",salaries);
        session.setAttribute("totalPages",totalPages);
        return "employee/listSalary";
    }
    @RequestMapping("/showSalary")
    public String showSalary(int currentPage,HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        int pageSize=10;
        int currentRow=(currentPage-1)*pageSize;
        List<Salary> salaries = salaryService.queryPageByEmployeeId(employeeId,currentRow,pageSize);
        session.setAttribute("salaries",salaries);
        return "employee/listSalary";
    }
    @RequestMapping("/dissentMiddle")
    public String dissentMiddle(int year,int month,int salaryId,HttpSession session)throws Exception{
        session.setAttribute("year",year);
        session.setAttribute("month",month);
        session.setAttribute("salaryId",salaryId);
        return "employee/dissent";
    }
    @RequestMapping("/dissent")
    public String dissent(String reason,double money,HttpSession session)throws Exception{
        int year= (int) session.getAttribute("year");
        int month= (int) session.getAttribute("month");
        int salaryId= (int) session.getAttribute("salaryId");
        int employeeId= (int) session.getAttribute("employeeId");
        Dissent dissent=new Dissent();
        dissent.setReason(reason);
        dissent.setMoney(money);
        dissent.setYear(year);
        dissent.setMonth(month);
        dissent.setEmployeeId(employeeId);
        dissent.setSalaryId(salaryId);
        dissent.setState(0);
        dissentService.add(dissent);
        return "employee/listSalary";
    }
    @RequestMapping("/selfMessage")
    public String selfMessage(HttpSession session)throws Exception{
        int employeeId= (int) session.getAttribute("employeeId");
        Employee employee=employeeService.queryById(employeeId);
        List<Dept> depts=deptService.queryAll();
        List<Post> posts=postService.queryAll();
        List<Train> trains=trainService.queryExist();
        session.setAttribute("employee",employee);
        session.setAttribute("depts",depts);
        session.setAttribute("posts",posts);
        session.setAttribute("trains",trains);
        return "employee/selfMessage";
    }
    @RequestMapping("/signOutAJAX")
    public void signOutAJAX(HttpServletResponse response)throws Exception{

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 17:00";
        Date date1=sdf.parse(time);
        String t=sdf1.format(date);

        if (date1.getTime()-date.getTime()>10800000){
            response.getWriter().print("sure absenteeism?");
        }else if (date1.getTime()-date.getTime()>0){
            response.getWriter().print("sure leave early?");
        }else {
            response.getWriter().print("sure signOut?");
        }
    }
}
