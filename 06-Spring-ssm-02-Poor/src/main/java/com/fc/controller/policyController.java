package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
@RequestMapping("policy")
@RestController
public class policyController {
    @Autowired
    private PolicyService policyService;
    @RequestMapping("click")
    public Map<String,Object>click(Long id, Date lastClickTime){
        return policyService.click(id,lastClickTime);
    }
    @RequestMapping("list")
    public Map<String,Object> list(Integer pageNum,Integer pageSize){
        return policyService.list(pageNum,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object>add(Alleviation alleviation){
        return policyService.add(alleviation);
    }
    @RequestMapping("update")
    public Map<String,Object>update(Alleviation alleviation){
        return policyService.update(alleviation);
    }
    @RequestMapping("del")
    public Map<String,Object>del(Alleviation id){
        return policyService.del(id);

    }
}
