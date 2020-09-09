package com.neusoft.controller;


import com.neusoft.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    //string响应
    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User();
        //假装这是调用service查出的结果
        user.setUsername("真不绰");
        user.setPassword("123");
        user.setAge(12);
        //model对象会存储在request中
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletResponse response, HttpServletRequest request) throws Exception
    {
        System.out.println("testVoid....");

        //请求转发去响应
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);


        response.sendRedirect(request.getContextPath()+"/index.jsp");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        response.getWriter().write("真不绰");
        return;
    }
}
