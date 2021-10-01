package com.afterglowit.controller;

import com.afterglowit.pojo.Admin;
import com.afterglowit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //切记：在所有的界面层，一定会出现业务逻辑层的对象
    @Autowired
    AdminService adminService;
    //实现登录判断，并进行相应方法
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name, pwd);
        if(admin != null){
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确!");
            return "login";
        }
    }
}
