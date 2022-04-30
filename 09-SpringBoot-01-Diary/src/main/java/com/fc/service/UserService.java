package com.fc.service;

import com.fc.Vo.ResultVO;
import com.fc.entity.TbUser;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService {
    ResultVO login(String username, String password);

    ResultVO update(MultipartFile img, TbUser tbUser);

    Map<String,Object> checkNick(String username);

}
