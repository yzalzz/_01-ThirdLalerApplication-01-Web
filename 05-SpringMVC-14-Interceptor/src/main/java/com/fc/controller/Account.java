package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class Account {
    @RequestMapping("getFood")
    public ModelAndView getFood(ModelAndView mv){
        System.out.println("链接数据库。。。。");
      List<Object> food = new ArrayList<>();
        food.add("洋葱");
        food.add("西瓜");
        food.add("苹果");
        food.add("西红柿");
        food.add("香菜");
        mv.addObject("foods",food);
        mv.setViewName("/account/getFood");



        return mv;
    }
}
