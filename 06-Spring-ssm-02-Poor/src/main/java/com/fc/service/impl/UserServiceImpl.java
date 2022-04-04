package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String,Object> updata(User user) {
        Map<String, Object> map = new HashMap<>();
        user.setId(9L);
        user.setPassword("12345");
        user.setUsername("哈哈");
        if (userMapper.updateByPrimaryKey(user) !=1){
            map.put("message","用户改变失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","用户改变成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }
//del
    @Override
    public Map<String,Object> del(Long id) {
        Map<String , Object> map = new HashMap<>();
        if(userMapper.deleteByPrimaryKey(8L)!=1){
            map.put("message","用户删除失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","用户删除成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }
    //add
    @Override
    public Map<String ,Object> add(User user) {
        Map<String, Object> map = new HashMap<>();
        if (userMapper.insert(user) !=1) {
            map.put("message", "用户添加失败");
            map.put("code", 400);
            map.put("success:", false);
            map.put("data", "errMsg:错误描述");
        } else {
            map.put("message", "用户添加成功");
            map.put("code", 200);
            map.put("success:", true);
            map.put("data", "");
        }
        return map;
    }

    //list
    @Override
    public Map<String, Object> list(Integer pageNum,Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectByExample(null);
        PageInfo<User> userPageInfo = new PageInfo<>(list);
        Map<String , Object> map = new HashMap<>();
        if (list==null){
            map.put("message","用户获取失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","用户获取成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data",userPageInfo.getList());
            map.put("data",userPageInfo);
        }
        return map;
    }

}
