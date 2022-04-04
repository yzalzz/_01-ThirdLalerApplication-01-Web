package com.fc.service;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;

import java.util.Map;

public interface commentService {
    Map<String, Object> list(Integer pageNum, Integer pageSize);

    Map<String, Object> add(MessageBoardWithBLOBs messageBoard);

    Map<String, Object> del(MessageBoard id);

}
