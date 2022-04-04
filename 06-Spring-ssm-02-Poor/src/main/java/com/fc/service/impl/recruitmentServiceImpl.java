package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.recruitmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class recruitmentServiceImpl implements recruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);

        Map<String, Object> map = new HashMap<>();
        List<VolunteerRecruitment> list = volunteerRecruitmentMapper.selectByExample(null);
        PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(list);
        if (list==null){
            map.put("message","获取失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","获取成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data",pageInfo.getList());
            map.put("data",pageInfo);
        }

        return map;
    }

    @Override
    public Map<String, Object> add(VolunteerRecruitment volunteerRecruitment) {
        Map<String, Object> map = new HashMap<>();
        volunteerRecruitment.setTotal("88888");
        if (volunteerRecruitmentMapper.insert(volunteerRecruitment) !=1) {
            map.put("message", "添加失败");
            map.put("code", 400);
            map.put("success:", false);
            map.put("data", "errMsg:错误描述");
        } else {
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("success:", true);
            map.put("data", "");
        }
        return map;
    }

    @Override
    public Map<String, Object> update(VolunteerRecruitment volunteerRecruitment) {
        Map<String, Object> map = new HashMap<>();
        volunteerRecruitment.setId(7L);
        volunteerRecruitment.setTotal("9999");
        if (volunteerRecruitmentMapper.updateByPrimaryKey(volunteerRecruitment)!=1){
            map.put("message","修改失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","修改成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }

    @Override
    public Map<String, Object> del(VolunteerRecruitment id) {

        Map<String, Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.deleteByPrimaryKey(7L)!=1){
            map.put("message","删除失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","删除成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }

        return map;
    }

    @Override
    public Map<String, Object> click(Long id,Date lastClickTime) {
        Map<String, Object> map = new HashMap<>();
        if (volunteerRecruitmentMapper.click(id,lastClickTime)!=1){
            map.put("message","设置失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","设置成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }

}

