package com.zf.controller;

import com.zf.model.User;
import com.zf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/registerMiddle")
    public String registerMiddle()throws Exception{
        return "register";
    }
    @RequestMapping("/nameAJAX")
    public void nameAJAX(String name, HttpServletResponse response)throws Exception{
        User user=userService.queryByName(name);
        if (user!=null){
            response.getWriter().print("账户名已存在");
        }
    }
    @RequestMapping("/login")
    public String login(String name,String pass,HttpSession session)throws Exception{
        User user=userService.queryByName(name);
        if (user!=null&&user.getPass().equals(pass)){
            session.setAttribute("userId",user.getId());
            return "recruitMessage";
        }else {
            return "../../index";
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
        session.setAttribute("userId",user1.getId());
        return "recruitMessage";
    }
}
