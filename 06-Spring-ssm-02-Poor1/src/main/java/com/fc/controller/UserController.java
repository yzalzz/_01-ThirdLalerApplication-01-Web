package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("food")
    public List<String> food(){
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        return list;
    }
}
