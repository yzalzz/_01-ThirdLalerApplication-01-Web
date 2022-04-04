package com.fc.service;

import com.fc.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {




     Map<String ,Object> list(Integer pageNum,Integer pageSize);


    Map<String, Object> del(Long id);

    Map<String, Object> updata(User user);

    Map<String, Object> add(User user);
}
