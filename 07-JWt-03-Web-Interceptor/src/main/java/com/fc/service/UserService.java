package com.fc.service;

import com.fc.Vo.UserVo;

public interface UserService {
    UserVo login(String username, String password);
}
