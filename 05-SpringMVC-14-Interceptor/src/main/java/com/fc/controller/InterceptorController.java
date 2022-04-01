package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class InterceptorController {
    @ResponseBody
    @RequestMapping(value = "test")
    public ModelAndView testInterceptor(ModelAndView mv){
        System.out.println("controller正在执行");
        mv.addObject("message","早睡早起");
        mv.setViewName("/index.jsp");
        return mv;
    }
}
