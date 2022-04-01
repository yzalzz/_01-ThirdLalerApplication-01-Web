package com.fc.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

//@ControllerAdvice配合@InitBinder 可以显示全局的初始化参数绑定 常见的用法是对Date日期的参数绑定
@ControllerAdvice
public class DataBindAdvice {
    @InitBinder
    //声明一个绑定器
    public void parseData(WebDataBinder binder){
        //设置自定义的格式化器
        binder.addCustomFormatter(new CustomDateFormatter());
    }
    //@ControllerAdvice配合@ModelAttribute 可以在controller执行前执行 并且被@ModelAttribute标注的方法返回值还可以供给后继接口方法使用
    @ModelAttribute("date")
    public Date getData(){
        Date date = new Date();
        System.out.println("controller执行前执行");
        return date;
    }
}
