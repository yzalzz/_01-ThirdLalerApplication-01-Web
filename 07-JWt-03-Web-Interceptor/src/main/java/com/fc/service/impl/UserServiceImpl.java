package com.fc.service.impl;

import com.fc.Vo.UserVo;
import com.fc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVo login(String username, String password) {
        UserVo userVo=null;
        //连接数据库
        if (username.equals("易烊千玺") && password.equals("123456")){
            userVo = new UserVo();
            userVo.setUsername(username);
            userVo.setLastAccessTime(new Date());
            userVo.setId(1);
        }

        return userVo;


    }
}
