/*
package com.shanxijuzhi.juzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    @RequestMapping(value = "")
    public String showIndexPage() {
        HttpSession session = getSession();
        String userName = (String) session.getAttribute("loginAct");
        if (userName == null || userName == "" || userName == "null") {
            return "login/login";
        } else {
            return "index";
        }
        //return "login/login";
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }
}
*/
