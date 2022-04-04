package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.entity.User;
import com.fc.service.commentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class commentServiceImpl implements commentService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<MessageBoard> list = messageBoardMapper.selectByExample(null);
        PageInfo<MessageBoard> pageInfo = new PageInfo<>(list);
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
            map.put("data",pageInfo.getList());
            map.put("data",pageInfo);
        }
        return map;
    }

    @Override
    public Map<String, Object> add(MessageBoardWithBLOBs messageBoard) {
       Map<String, Object> map = new HashMap<>();
        messageBoard.setUsername("9999");
        messageBoard.setPicture("5956");
        if (messageBoardMapper.insert( messageBoard) !=1) {
            map.put("message", "添加失败");
            map.put("code", 400);
            map.put("success:", false);
            map.put("data", "errMsg:错误描述");
            return map;
        } else {
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("success:", true);
            map.put("data", "");
        }
        return map;
    }

    @Override
    public Map<String, Object> del(MessageBoard id) {

        Map<String, Object> map = new HashMap<>();
        if (messageBoardMapper.deleteByPrimaryKey(6L)!=1){
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




