package com.zf.controller;

import com.zf.model.*;
import com.zf.service.*;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zf.util.DoPaging;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
        session.setAttribute("depts",deptService.queryAll());
        session.setAttribute("posts",postService.queryAll());
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
        resume.setState(4);
        Employee employee=new Employee();
        employee.setName(resume.getName());
        employee.setSex(resume.getSex());
        employee.setBirthday(resume.getBirthday());
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
    public String updateRecruit(int recruitId,String requirement,String salaryRange,String introduction,String address,HttpSession session)throws Exception{
        Recruit recruit=recruitService.queryById(recruitId);
        recruit.setRequirement(requirement);
        recruit.setSalaryRange(salaryRange);
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
    public String adminBack(HttpSession session)throws Exception{
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

    @RequestMapping("/listDepts")
    public void getDepts(HttpServletResponse response)throws Exception{
        List<Dept> depts = deptService.queryAll();
        JSONArray array=JSONArray.fromObject(depts);
        response.getWriter().print(array);
    }
    @RequestMapping("/listPostByDeptId")
    public void listPostByDeptId(int deptId, HttpServletResponse response)throws Exception{
        List<Post> posts = postService.queryByDeptId(deptId);
        JSONArray array=JSONArray.fromObject(posts);
//        System.out.println("post:"+array);
        response.getWriter().print(array);
    }
}
