package com.neusoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello Controller");
        return "success";
    }

    @RequestMapping(value = "/testRequestMapping",params = {"username"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("testRequestMapping....");
        return "success";
    }
}
