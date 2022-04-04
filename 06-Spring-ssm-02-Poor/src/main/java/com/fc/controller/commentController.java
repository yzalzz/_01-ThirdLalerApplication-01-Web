package com.fc.controller;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("comment")
@RestController
public class commentController {
    @Autowired
    private commentService commentService;
    @RequestMapping("list")
    public Map<String,Object> list(Integer pageNum,Integer pageSize){
       return commentService.list(pageNum,pageSize);
    }
    @RequestMapping("add")
    public Map<String ,Object>add(MessageBoardWithBLOBs messageBoard){
        return commentService.add(messageBoard);
    }
    @RequestMapping("del")
    public Map<String,Object>del(MessageBoard id){
        return commentService.del(id);
    }

}
