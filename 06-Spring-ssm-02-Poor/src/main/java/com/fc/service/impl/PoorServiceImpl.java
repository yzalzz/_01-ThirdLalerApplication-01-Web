package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize,String username) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<Poor> list = poorMapper.selectByExample(null);
        PageInfo<Poor> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        if (list == null) {
            map.put("message", "获取失败");
            map.put("code", 400);
            map.put("success:", false);
            map.put("data", "errMsg:错误描述");
            return map;
        } else {
            map.put("message", "获取成功");
            map.put("code", 200);
            map.put("success:", true);
            map.put("data", pageInfo.getList());
            map.put("data", pageInfo);
        }

        return map;
    }

    @Override
    public Map<String, Object> add(Poor poor) {
        Map<String, Object> map = new HashMap<>();
        poor.setAddress("888888");
        poor.setAudit("555");
    if (poorMapper.add(poor) !=1) {
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
    public Map<String, Object> update(Poor poor) {
        Map<String, Object> map = new HashMap<>();
        poor.setId(6L);
        poor.setAddress("999999");

        if (poorMapper.updateByPrimaryKey(poor)!=1){
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
    public Map<String, Object> del(Poor id) {
        Map<String, Object> map = new HashMap<>();
        if (poorMapper.deleteByPrimaryKey(6L)!=1){
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
        if (poorMapper.click(id,lastClickTime)!=1){
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



