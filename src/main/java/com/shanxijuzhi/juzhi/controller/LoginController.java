package com.shanxijuzhi.juzhi.controller;
import com.shanxijuzhi.juzhi.model.User;
import com.shanxijuzhi.juzhi.service.UserService;
import com.shanxijuzhi.juzhi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private User user;

    @Autowired
    private UserService userService;



    public String m_strPageIndex = "/home/indexlogin";

    @GetMapping("/login")
    public String login(){

        System.out.println("进入登录方法");

        return "login/log";
    }


    @RequestMapping(value = "/loginUser",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8;", "application/json;"})
    @ResponseBody
    public String login(HttpServletRequest request, HttpSession httpSession,
                        String loginAct,
                        String loginPwd) throws Exception {

        m_strPageIndex = "/home/indexlogin";
        String loginPwd1 = MD5Util.encode(loginPwd);

        User user = userService.login(loginAct,loginPwd1);
        if (httpSession == null){
            m_strPageIndex = "请重新登录";
        }
        if (loginAct == null){
            m_strPageIndex = "用户名或密码错误";
        }


        if (user == null){
            m_strPageIndex = "用户账号或密码错误";
        }
        //判断用户是否被锁定
        if (user != null && user.getStatus() == 0){
            m_strPageIndex = "对不起该账号锁定，请联系管理员";

        }



        //将用户的信息存放到session中
        request.getSession().setAttribute("user",user);


        return m_strPageIndex;
    }
}
