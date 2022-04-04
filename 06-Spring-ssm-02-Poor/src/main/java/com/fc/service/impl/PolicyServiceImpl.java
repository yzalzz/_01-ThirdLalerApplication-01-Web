package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.PolicyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public Map<String, Object> click(Long id,Date lastClickTime) {
        Map<String, Object> map = new HashMap<>();
       if (alleviationMapper.click(id,lastClickTime)!=1){
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

    @Override
    public Map<String, Object> list(Integer pageNum,Integer pageSize) {
        Map<String , Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Alleviation> list = alleviationMapper.selectByExample(null);
        PageInfo<Alleviation> pageInfo = new PageInfo<>(list);
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
    public Map<String, Object> add(Alleviation alleviation) {
        Map<String, Object> map = new HashMap<>();
        alleviation.setType("44444");
        alleviation.setContent("5555");
         alleviationMapper.insert(alleviation);
        if (alleviationMapper.insert(alleviation) !=1) {
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
    public Map<String, Object> update(Alleviation alleviation) {
        Map<String, Object> map = new HashMap<>();
        alleviation.setId(7L);
        alleviation.setType("852");
        alleviationMapper.updateByPrimaryKey(alleviation);
        if (alleviationMapper.updateByPrimaryKey(alleviation)!=1){
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
    public Map<String, Object> del(Alleviation id) {
        Map<String, Object> map = new HashMap<>();
        if (alleviationMapper.deleteByPrimaryKey(6L)!=1){
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
}
