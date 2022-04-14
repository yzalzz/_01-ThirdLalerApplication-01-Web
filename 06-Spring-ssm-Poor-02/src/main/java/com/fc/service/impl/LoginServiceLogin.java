package com.fc.service.impl;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.LoginService;
import com.fc.util.JwtUtil;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceLogin implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVo checkUser(String username, String password) {
        ResultVo resultVo=null;
        User user = userMapper.login(username);
        if (username!=null){
            if (username.equals(user.getUsername())&&password.equals(user.getPassword())){
                Map<String,Object>claim=new HashMap<>();
                //创建token
                String token = JwtUtil.createToken(claim, System.currentTimeMillis() * 1000 * 60);

                resultVo = new ResultVo(200, "登录成功", true,token );
            }else {
                resultVo = new ResultVo(400, "登录失败", false,"" );
            }
        }else {
            resultVo = new ResultVo(400, "登录失败", false,"" );
        }
        System.out.println(user);
        return resultVo;
    }
}
