package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.recruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RequestMapping("recruitment")
@RestController
public class recruitmentController {
    @Autowired
    private recruitmentService recruitmentService;
    @RequestMapping("list")
    public Map<String ,Object>list(Integer pageNum,Integer pageSize){
        return recruitmentService.list(pageNum,pageSize);
    }
    @RequestMapping("add")
    public Map<String,Object>add(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }
    @RequestMapping("update")
    public Map<String,Object>update(VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.update(volunteerRecruitment);
    }
    @RequestMapping("del")
    public  Map<String,Object>del(VolunteerRecruitment id){
        return recruitmentService.del(id);
    }
    @RequestMapping("click")
    public Map<String,Object>click(Long id, Date lastClickTime){
        return recruitmentService.click(id,lastClickTime);
    }

}
