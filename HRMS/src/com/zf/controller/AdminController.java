package com.zf.controller;

import com.zf.model.Resume;
import com.zf.service.RecruitService;
import com.zf.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.DoPaging;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/listResume")
    public String listResume(HttpSession session)throws Exception{
        List<Resume> resumeList = resumeService.queryAll();//得到所有要显示的数据
        int totalRows = resumeList.size();//得到总行数
        int pageSize=3;
        int totalPages = DoPaging.getTotalPages(pageSize,totalRows);//得到总页数
        List<Resume> resumes = resumeService.queryPage(0,pageSize);
        session.setAttribute("resumes",resumes);
        session.setAttribute("totalPages",totalPages);
       return "admin/listResume";
    }
    @RequestMapping("/inform")
    public String inform(int resumeId,HttpSession session)throws Exception{
        Resume resume=resumeService.queryById(resumeId);
        resume.setState(2);
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
}
