package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    //controller层调用service层
    @Autowired
    private UserService userService;

    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, User param) {
        return userService.list(pageNum, pageSize, param);
    }

    @GetMapping("delete")
    public ResultVo del(Long id) {
        return userService.del(id);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody User user) {
        return userService.updata(user);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody User user) {
        return userService.add(user);
    }
    @PostMapping("login")
    public ResultVo login(@RequestBody User user){
        return userService.login(user.getUsername(),user.getPassword());
    }

}

