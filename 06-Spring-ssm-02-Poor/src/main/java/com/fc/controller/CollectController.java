package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("collect")
public class CollectController {
    //
    @Autowired
    private CollectService collectService;
    @RequestMapping("list")
    public Map<String,Object> list(Integer pageNum,Integer pageSize){
       return collectService.list(pageNum,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object> add(Collection collection){
        return collectService.add(collection);
    }
    @RequestMapping("del")
    public Map<String,Object> del(Collection id){
       return collectService.del(id);
    }
}
