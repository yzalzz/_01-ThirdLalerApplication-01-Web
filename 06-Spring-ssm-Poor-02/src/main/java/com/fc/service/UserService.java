package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVo;

public interface UserService {




     ResultVo list(Integer pageNum, Integer pageSize, Long id);


    ResultVo del(Long id);

    ResultVo updata(User user);

    ResultVo add(User user);




}
