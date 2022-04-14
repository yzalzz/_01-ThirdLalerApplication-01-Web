package com.fc.service;

import com.fc.Vo.UserVo;
import com.fc.entity.User;

import java.util.Map;

public interface UserService {


    UserVo login(String username, String password);

}
