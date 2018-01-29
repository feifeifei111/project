package com.zf.controller;

import com.zf.model.Post;
import com.zf.model.Recruit;
import com.zf.model.Resume;
import com.zf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.DoPaging;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/addRecruitMiddle")
    public String addRecruitMiddle(HttpSession session)throws Exception{
        return "admin/addRecruit";
    }
    @RequestMapping("/addRecruit")
    public String addRecruit(Recruit recruit,HttpSession session)throws Exception{
        recruit.setState(1);
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
    public String hire(int resumeId,HttpSession session)throws Exception{
        Resume resume=resumeService.queryById(resumeId);
        resume.setState(4);
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
    @RequestMapping("/postMessage")
    public String postMessage(int deptId,HttpSession session)throws Exception{
        session.setAttribute("posts",postService.queryByDeptId(deptId));
        return "admin/postManagement";
    }
    @RequestMapping("/employeeMessage")
    public String employeeMessage(int postId,HttpSession session)throws Exception{
        session.setAttribute("employees",employeeService.queryByPostId(postId));
        return "admin/employeeManagement";
    }
}
