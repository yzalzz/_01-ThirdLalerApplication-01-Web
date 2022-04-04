package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    //controller层调用service层
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public Map<String,Object> list(Integer pageNum,Integer pageSize){
       return  userService.list(pageNum,pageSize);
    }
    @RequestMapping("del")
    public Map<String,Object> del(Long id){
        return userService.del(id);
    }
    @RequestMapping("updata")
    public Map<String,Object> updata(User user){
       return userService.updata(user);
    }
    @RequestMapping("add")
    public Map<String ,Object> add(@RequestBody User user) {
        return userService.add(user);
    }

}
