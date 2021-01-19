package com.shanxijuzhi.juzhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {


    @GetMapping("/")
    public String Log(){
        return "log";
    }

}
