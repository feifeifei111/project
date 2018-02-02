package com.zf.controller;

import com.zf.model.CheckOn;
import com.zf.service.CheckOnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployController {
    @Resource
    private CheckOnService checkOnService;

    @RequestMapping("/signIn")
    public void signIn(HttpSession session)throws Exception{
        CheckOn checkOn=new CheckOn();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");

        checkOn.setBeginTime();
    }
}
