package com.zf.controller;

import com.zf.model.*;
import com.zf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zf.util.DoPaging;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private TrainService trainService;
    @Resource
    private RewAndPunService rewAndPunService;
    @Resource
    private AttendanceService attendanceService;
    @Resource
    private SalaryService salaryService;

    @RequestMapping("/addRecruitMiddle")
    public String addRecruitMiddle(HttpSession session)throws Exception{
        session.setAttribute("depts",deptService.queryAll());
//        session.setAttribute("posts",postService.queryAll());
        return "admin/addRecruit";
    }
    @RequestMapping("/addRecruit")
    public String addRecruit(Recruit recruit,HttpSession session)throws Exception{
        recruit.setCreateTime(new Date());
        recruitService.add(recruit);
        List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
        int totalRows = recruitList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Recruit> recruits = recruitService.queryPage(0,pageSize);
        session.setAttribute("recruits",recruits);
        session.setAttribute("totalPages",totalPages);
        return "admin/recruitPage";
    }
    @RequestMapping("/recruitPage")
    public String recruitPage(HttpSession session)throws Exception{
        List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
        int totalRows = recruitList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Recruit> recruits = recruitService.queryPage(0,pageSize);
        session.setAttribute("recruits",recruits);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
        return "admin/recruitPage";
    }
    @RequestMapping("/listResume")
    public String listResume(HttpSession session)throws Exception{
        List<Resume> resumeList = resumeService.queryAll();//得到所有要显示的数据
        int totalRows = resumeList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Resume> resumes = resumeService.queryPage(0,pageSize);
        session.setAttribute("resumes",resumes);
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
        session.setAttribute("recruits",recruitService.queryAll());
        session.setAttribute("totalPages",totalPages);
       return "admin/listResume";
    }
    @RequestMapping("/inform")
    public String inform(int resumeId,String interviewTime,HttpSession session)throws Exception{
        Resume resume=resumeService.queryById(resumeId);
        resume.setState(2);
        resume.setInterviewTime(interviewTime);
        resumeService.update(resume);
        List<Resume> resumeList = resumeService.queryAll();//得到所有要显示的数据
        int totalRows = resumeList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Resume> resumes = resumeService.queryPage(0,pageSize);
        session.setAttribute("resumes",resumes);
        session.setAttribute("totalPages",totalPages);
        return "admin/listResume";
    }
    @RequestMapping("/hire")
    public String hire(int postId,int resumeId,HttpSession session)throws Exception{
        Resume resume=resumeService.queryById(resumeId);
        Recruit recruit=recruitService.queryById(resume.getRecruitId());
        resume.setState(4);
        Employee employee=new Employee();
        employee.setName(resume.getName());
        employee.setSex(resume.getSex());
        employee.setBirthday(resume.getBirthday());
        employee.setBasicSalary(recruit.getSalary());
        employee.setState(1);
        employee.setPostId(postId);
        employee.setUserId(resume.getUserId());
        employee.setCreateTime(new Date());
        employeeService.add(employee);//
        resumeService.update(resume);
        List<Resume> resumeList = resumeService.queryAll();//得到所有要显示的数据
        int totalRows = resumeList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Resume> resumes = resumeService.queryPage(0,pageSize);
        session.setAttribute("resumes",resumes);
        session.setAttribute("totalPages",totalPages);
        return "admin/listResume";
    }
    @RequestMapping("/unHire")
    public String unHire(int postId,int resumeId,HttpSession session)throws Exception{
        Resume resume=resumeService.queryById(resumeId);
        resume.setState(0);
        resumeService.update(resume);
        List<Resume> resumeList = resumeService.queryAll();//得到所有要显示的数据
        int totalRows = resumeList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Resume> resumes = resumeService.queryPage(0,pageSize);
        session.setAttribute("resumes",resumes);
        session.setAttribute("totalPages",totalPages);
        return "admin/listResume";
    }
    @RequestMapping("/showResume")
    public String showResume(int currentPage,HttpSession session)throws Exception{
        int pageSize=3;
        int currentRow=(currentPage-1)*pageSize;
        List<Resume> resumes = resumeService.queryPage(currentRow,pageSize);
        session.setAttribute("resumes",resumes);
        return "admin/listResume";
    }
    @RequestMapping("/deptManagement")
    public String deptManagement(HttpSession session)throws Exception{
        session.setAttribute("depts",deptService.queryAll());
        return "admin/deptManagement";
    }
    @RequestMapping("/postManagement")
    public String postManagement(int deptId, HttpSession session)throws Exception{
        session.setAttribute("posts",postService.queryByDeptId(deptId));
        session.setAttribute("deptId",deptId);
        return "admin/postManagement";
    }
    @RequestMapping("/employeeMessage")
    public String employeeMessage(int postId,HttpSession session)throws Exception{
        List<Employee> employeeList1 = employeeService.queryByPostId(postId);//得到所有要显示的数据
        int totalRows = employeeList1.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Employee> employeeList = employeeService.queryPage(postId,0,pageSize);
        session.setAttribute("employeeList",employeeList);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
        session.setAttribute("postId",postId);
        return "admin/employeeManagement";
    }
    @RequestMapping("/showEmployee")
    public String showEmployee(int currentPage,int postId,HttpSession session)throws Exception{
        List<Employee> employeeList1 = employeeService.queryByPostId(postId);//得到所有要显示的数据
        int totalRows = employeeList1.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        int currentRow=(currentPage-1)*pageSize;
        List<Employee> employeeList = employeeService.queryPage(postId,currentRow,pageSize);
        session.setAttribute("employeeList",employeeList);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
        session.setAttribute("postId",postId);
        return "admin/employeeManagement";
    }
    @RequestMapping("/changePost")
    public String changePost(int employeeId,int postId,HttpSession session)throws Exception{
        Employee employee=employeeService.queryById(employeeId);
        employee.setPostId(postId);
        employeeService.update(employee);
        List<Employee> employeeList1 = employeeService.queryByPostId(postId);//得到所有要显示的数据
        int totalRows = employeeList1.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Employee> employeeList = employeeService.queryPage(postId,0,pageSize);
        session.setAttribute("employeeList",employeeList);
        return "admin/employeeManagement";
    }
    @RequestMapping("/dismiss")
    public String dismiss(int employeeId,HttpSession session)throws Exception{
        Employee employee=employeeService.queryById(employeeId);
        employee.setState(0);
        employeeService.update(employee);
        Employee employee1=employeeService.queryById(employeeId);
        int pageSize=3;
        List<Employee> employeeList = employeeService.queryPage(employee1.getPostId(),0,pageSize);
        session.setAttribute("employeeList",employeeList);
        return "admin/employeeManagement";
    }
    @RequestMapping("/updateRecruitMiddle")
    public String updateRecruitMiddle(int recruitId,HttpSession session)throws Exception{
        Recruit recruit=recruitService.queryById(recruitId);
        session.setAttribute("recruit",recruit);
        return "admin/updateRecruit";
    }
    @RequestMapping("/updateRecruit")
    public String updateRecruit(int recruitId,String requirement,int salaryRange,String introduction,String address,HttpSession session)throws Exception{
        Recruit recruit=recruitService.queryById(recruitId);
        recruit.setRequirement(requirement);
        recruit.setSalary(salaryRange);
        recruit.setIntroduction(introduction);
        recruit.setAddress(address);
        recruitService.update(recruit);
        List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
        int totalRows = recruitList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Recruit> recruits = recruitService.queryPage(0,pageSize);
        session.setAttribute("recruits",recruits);
        session.setAttribute("totalPages",totalPages);
        return "admin/recruitPage";
    }
    @RequestMapping("/delete")
    public String delete(int recruitId,HttpSession session)throws Exception{
        recruitService.delete(recruitId);
        List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
        int totalRows = recruitList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Recruit> recruits = recruitService.queryPage(0,pageSize);
        session.setAttribute("recruits",recruits);
        session.setAttribute("totalPages",totalPages);
        return "admin/recruitPage";
    }
    @RequestMapping("/adminBack")
    public String adminBack()throws Exception{
        return "admin/adminSuccess";
    }
    @RequestMapping("/addDept")
    public String addDept(String name,HttpSession session)throws Exception{
        Dept dept=new Dept();
        dept.setName(name);
        dept.setCreateTime(new Date());
        deptService.add(dept);
        session.setAttribute("depts",deptService.queryAll());
        return "admin/deptManagement";
    }
    @RequestMapping("/deleteDept")
    public String deleteDept(int deptId,HttpSession session)throws Exception{
        List<Post> posts=postService.queryByDeptId(deptId);
        boolean flag=false;
        for (Post post:posts){
            if (employeeService.queryByPostId(post.getId()).size()!=0){
                flag=true;
                break;
            }
        }
        if (flag){
            return "admin/deptManagement";
        }else {
            postService.deleteByDeptId(deptId);
            deptService.delete(deptId);
            session.setAttribute("depts",deptService.queryAll());
            return "admin/deptManagement";
        }
    }
    @RequestMapping("/addPost")
    public String addPost(int deptId,String name,String description,HttpSession session)throws Exception{
        Post post=new Post();
        post.setName(name);
        post.setDescription(description);
        post.setDeptId(deptId);
        post.setCreateTime(new Date());
        postService.add(post);
        session.setAttribute("posts",postService.queryAll());
        return "admin/postManagement";
    }
    @RequestMapping("/deletePost")
    public String deletePost(int postId,HttpSession session)throws Exception{
        postService.delete(postId);
        session.setAttribute("posts",postService.queryAll());
        return "admin/postManagement";
    }
    @RequestMapping("/searchEmployee")
    public String searchEmployee(String name,HttpSession session)throws Exception{
        List<Employee> employees=employeeService.queryByLikeName(name);
        if (employees.size()!=0){
            session.setAttribute("employees",employees);
            session.setAttribute("depts",deptService.queryAll());
            session.setAttribute("posts",postService.queryAll());
            return "admin/listEmployee";
        }else {
            return "admin/deptManagement";
        }
    }

    @RequestMapping("/trainManagementMiddle")
    public String trainManagementMiddle(HttpSession session)throws Exception{
        session.setAttribute("trains",trainService.queryExist());
        return "admin/trainManagement";
    }
    @RequestMapping("/addTrain")
    public String addTrain(Train train,HttpSession session)throws Exception{
        train.setState(1);
        trainService.add(train);
        session.setAttribute("trains",trainService.queryExist());
        return "admin/trainManagement";
    }
    @RequestMapping("/deleteTrain")
    public String deleteTrain(int id,HttpSession session)throws Exception{
        List<Employee> employees=employeeService.queryByTrainId(id);
        if (employees.size()==0){
            trainService.delete(id);
            session.setAttribute("trains",trainService.queryExist());
            return "admin/trainManagement";
        }else {
            session.setAttribute("trains",trainService.queryExist());
            return "admin/trainManagement";
        }
    }
    @RequestMapping("/updateTrain")
    public String updateTrain(Train train,HttpSession session)throws Exception{
        List<Employee> employees=employeeService.queryByTrainId(train.getId());
        if (employees.size()==0){
            trainService.update(train);
            session.setAttribute("trains",trainService.queryExist());
            return "admin/trainManagement";
        }else {
            session.setAttribute("trains",trainService.queryExist());
            return "admin/trainManagement";
        }
    }
    @RequestMapping("/arrangeTrain")
    public String arrangeTrain( int employeeId,HttpSession session)throws Exception{
        session.setAttribute("employeeId",employeeId);
        session.setAttribute("trains",trainService.queryExist());
        return "admin/selectTrain";
    }
    @RequestMapping("/addEmployeeTrain")
    public String addEmployeeTrain( int employeeId,int trainId,HttpSession session)throws Exception{
        Employee employee=employeeService.queryById(employeeId);
        Train train=trainService.queryById(trainId);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date1=sdf.parse(train.getBeginTime());
        if (date.getTime()<date1.getTime()){
            employee.setTrainId(trainId);
            employeeService.update(employee);
        }
        List<Employee> employeeList1 = employeeService.queryByPostId(employee.getPostId());//得到所有要显示的数据
        int totalRows = employeeList1.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Employee> employeeList = employeeService.queryPage(employee.getPostId(),0,pageSize);
        session.setAttribute("employeeList",employeeList);
        session.setAttribute("totalPages",totalPages);
        return "admin/employeeManagement";
    }
    @RequestMapping("/arrangeDeptTrain")
    public String arrangeDeptTrain(int deptId,HttpSession session)throws Exception{
        session.setAttribute("deptId",deptId);
        session.setAttribute("trains",trainService.queryExist());
        return "admin/selectDeptTrain";
    }
    @RequestMapping("/addDeptTrain")
    public String addDeptTrain( int trainId,HttpSession session)throws Exception{
        int deptId= (int) session.getAttribute("deptId");
        Train train=trainService.queryById(trainId);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date1=sdf.parse(train.getBeginTime());
        if (date.getTime()<date1.getTime()){

            List<Post> posts=postService.queryByDeptId(deptId);
            for (Post post:posts){
                List<Employee>employees=employeeService.queryByPostId(post.getId());
                for (Employee employee:employees){
                    if (employee.getTrainId()==0){
                        employee.setTrainId(trainId);
                        employeeService.update(employee);
                    }
                }
            }
        }
        return "admin/deptManagement";
    }
    @RequestMapping("/getPostByDept")
    public @ResponseBody List<Post> getPostByDept(int d)throws Exception{
        List<Post>positions=postService.queryByDeptId(d);
        System.out.println(positions);
        return positions;
    }
    @RequestMapping("/calculateSalary")
    public String calculateSalary(HttpSession session)throws Exception{
        List<Employee>employees=employeeService.queryAll();
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        if (month==1){
            month=12;
            year-=1;
        }else {
            month-=1;
        }
        List<Salary>salaryList=salaryService.queryByYM(year,month);
        if (salaryList.size()==0){
            for (Employee employee:employees){
                List<Attendance>attendances=attendanceService.queryByYM(year,month,employee.getId());
                if (attendances.size()!=22){
                    RewAndPun rewAndPun=new RewAndPun();
                    rewAndPun.setMoney(employee.getBasicSalary()*(attendances.size()-22)/22);
                    rewAndPun.setTime(year+"年"+month+"月");
                    rewAndPun.setYear(year);
                    rewAndPun.setMonth(month);
                    if (attendances.size()<22){
                        rewAndPun.setCause("缺勤"+(22-attendances.size())+"天");
                    }else {
                        rewAndPun.setCause("加班"+(attendances.size()-22)+"天");
                    }
                    rewAndPun.setEmployeeId(employee.getId());
                    rewAndPunService.add(rewAndPun);
                }
                double rp=0;
                List<RewAndPun>rewAndPuns=rewAndPunService.queryByEYM(employee.getId(),year,month);
                for (RewAndPun rewAndPun:rewAndPuns){
                    rp+=rewAndPun.getMoney();
                }
                Salary salary=new Salary();
                salary.setBasic(employee.getBasicSalary());
                salary.setBonus(employee.getBasicSalary()*0.3);
                salary.setSocial(-employee.getBasicSalary()*0.15);
                salary.setRewAndPun(rp);
                salary.setYear(year);
                salary.setMonth(month);
                salary.setEmployeeId(employee.getId());
                salaryService.add(salary);
            }
            /*String calculated="已结算上月工资";
            session.setAttribute("calculated",calculated);*/
            return "admin/adminSuccess";
        }else {
            /*String calculated="已结算过上月工资,不必重复结算";
            session.setAttribute("calculated",calculated);*/
            return "admin/adminSuccess";
        }
    }
}
