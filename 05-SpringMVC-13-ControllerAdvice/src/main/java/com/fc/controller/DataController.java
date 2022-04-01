package com.fc.controller;

import com.fc.entity.Student;
import com.fc.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("DataController")
public class DataController {
    @RequestMapping("date")
    @ResponseBody
    public Map<Object, Object> date(Date date){
        Map<Object, Object> map = new HashMap<>();

        map.put("data",date);

        return map;
    }
    @RequestMapping("getBind")
    @ResponseBody
    public Map<Object, Object> getBind(Student student, Teacher teacher){
        Map<Object, Object> map = new HashMap<>();
        map.put("student",student);
        map.put("teacher",teacher);
        return map;
    }
    @InitBinder("student")
    public void  getStudent(WebDataBinder binder){
        //设置默认的前置名
        binder.setFieldDefaultPrefix("student.");
    }
    @InitBinder("teacher")
    public void  getTeacher(WebDataBinder binder){
        //设置默认的前置名
        binder.setFieldDefaultPrefix("teacher.");
    }
    @RequestMapping("getDate")
    @ResponseBody
    public Map<Object, Object> getDate(@ModelAttribute("date") Date date){
       Map<Object, Object> map = new HashMap<>();
       map.put("date",date);
       return map;
    }
}
