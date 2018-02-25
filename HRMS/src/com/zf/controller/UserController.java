package com.zf.controller;

import com.zf.model.*;
import com.zf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zf.util.DoPaging;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("/registerMiddle")
    public String registerMiddle()throws Exception{
        return "user/register";
    }
    @RequestMapping("/nameAJAX")
    public void nameAJAX(String name, HttpServletResponse response)throws Exception{
        User user=userService.queryByName(name);
        if (user!=null){
            response.getWriter().print("账户名已存在");
        }
    }
    @RequestMapping("/login")
    public String login(String name,String pass,int identify,HttpSession session)throws Exception{
        if (identify==0){
            User user=userService.queryByName(name);
            if (user!=null&&user.getPass().equals(pass)){
                List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
                int totalRows = recruitList.size();//得到总行数
                int pageSize=3;
                int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
                List<Recruit> recruits = recruitService.queryPage(0,pageSize);
                Resume resume=resumeService.queryUserId(user.getId());
                session.setAttribute("recruits",recruits);
                session.setAttribute("totalPages",totalPages);
                session.setAttribute("userId",user.getId());
                session.setAttribute("depts",deptService.queryAll());
                session.setAttribute("posts",postService.queryAll());
                session.setAttribute("resume",resume);
                return "user/userSuccess";
            }else {
                return "../../index";
            }
        }else if (identify==1){
            User user=userService.queryByName(name);
            if (user!=null&&user.getPass().equals(pass)){
                Employee employee=employeeService.queryByUserId(user.getId());
                if (employee!=null){
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    String today=sdf.format(date);
                    Attendance attend= attendanceService.queryByTodayEmployeeId(today,employee.getId());
                    session.setAttribute("attend",attend);
                    session.setAttribute("employeeId",employee.getId());
                    return "employee/employeeSuccess";
                }else {
                    return "../../index";
                }
            }else {
                return "../../index";
            }
        }else {
            if (name.equals("aaa123")&&pass.equals("aaa123")){
                return "admin/adminSuccess";
            }else {
                return "../../index";
            }
        }
    }
    @RequestMapping("/register")
    public String register(String name,String pass1,String sex,int age,String phone,String email,HttpSession session)throws Exception{
        Date createTime=new Date();
        User user=new User();
        user.setName(name);
        user.setPass(pass1);
        user.setSex(sex);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        user.setCreateTime(createTime);
        userService.addUser(user);
        User user1=userService.queryByName(name);
        List<Recruit> recruitList = recruitService.queryAll();//得到所有要显示的数据
        int totalRows = recruitList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Recruit> recruits = recruitService.queryPage(0,pageSize);
        session.setAttribute("recruits",recruits);
        session.setAttribute("totalPages",totalPages);
        session.setAttribute("userId",user1.getId());
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
        return "user/userSuccess";
    }
    @RequestMapping("/showRecruit")
    public String showRecruit(int currentPage,HttpSession session)throws Exception{
        int pageSize=3;
        int currentRow=(currentPage-1)*pageSize;
        List<Recruit> recruitMessages = recruitService.queryPage(currentRow,pageSize);
        session.setAttribute("recruitMessages",recruitMessages);
        return "user/userSuccess";
    }
    @RequestMapping("/apply")
    public String apply(int recruitId,HttpSession session)throws Exception{
        int userId= (int) session.getAttribute("userId");
        Resume resume=resumeService.queryUserId(userId);
        if (resume==null){
            return "user/addResume";
        }else {
            if (resume.getState()!=0){
                session.setAttribute("resume",resume);
                return "user/userSuccess";
            }else {
                resume.setRecruitId(recruitId);
                resume.setState(1);
                resumeService.update(resume);
                session.setAttribute("resume",resumeService.queryUserId(userId));
                return "user/userSuccess";
            }
        }
    }
    @RequestMapping("/back")
    public String back(HttpSession session)throws Exception{
        return "user/userSuccess";
    }
    @RequestMapping("/addResume")
    public String addResume(Resume resume,HttpSession session)throws Exception{
        int userId= (int) session.getAttribute("userId");
        Date createTime=new Date();
        resume.setState(0);
        resume.setUserId(userId);
        resume.setRecruitId(0);
        resume.setCreateTime(createTime);
        resumeService.add(resume);
        return "user/userSuccess";
    }
    @RequestMapping("/updateResumeMiddle")
    public String updateRusumeMiddle(HttpSession session)throws Exception{
        return "user/updateResume";
    }
    @RequestMapping("/updateResume")
    public String updateResume(Resume resume,HttpSession session)throws Exception{
        int userId= (int) session.getAttribute("userId");
        Resume resume1=resumeService.queryUserId(userId);
        resume1.setName(resume.getName());
        resume1.setSex(resume.getSex());
        resume1.setBirthday(resume.getBirthday());
        resume1.setBirthPlace(resume.getBirthPlace());
        resume1.setNation(resume.getNation());
        resume1.setPoliticalStatus(resume.getPoliticalStatus());
        resume1.setHealthy(resume.getHealthy());
        resume1.setMarriage(resume.getMarriage());
        resume1.setEducation(resume.getEducation());
        resume1.setPhone(resume.getPhone());
        resume1.setEmail(resume.getEmail());
        resume1.setMajor(resume.getMajor());
        resume1.setSchool(resume.getSchool());
        resume1.setCompetence(resume.getCompetence());
        resume1.setPost(resume.getPost());
        resume1.setExperience(resume.getExperience());
        resume1.setAward(resume.getAward());
        resume1.setSelfComment(resume.getSelfComment());
        resume1.setHobbyOrSpeciality(resume.getHobbyOrSpeciality());
        resumeService.update(resume1);
        return "user/userSuccess";
    }
    @RequestMapping("/process")
    public String process(HttpSession session)throws Exception{
        int userId= (int) session.getAttribute("userId");
        Resume resume=resumeService.queryUserId(userId);
        session.setAttribute("resume",resume);
        return "user/process";
    }
    @RequestMapping("/sureInterview")
    public String sureInterview(HttpSession session)throws Exception{
        int userId= (int) session.getAttribute("userId");
        Resume resume=resumeService.queryUserId(userId);
        resume.setState(3);
        resumeService.update(resume);
        Resume resume1=resumeService.queryUserId(userId);
        session.setAttribute("resume",resume1);
        return "user/userSuccess";
    }
    @RequestMapping("/employeeLogin")
    public String employeeLogin()throws Exception{
        return "../../index";
    }
}
