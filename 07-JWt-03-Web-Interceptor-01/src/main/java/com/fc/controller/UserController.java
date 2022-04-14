package com.fc.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fc.Vo.UserVo;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public Map<String,Object> login(User user){
        UserVo userVo=userService.login(user.getUsername(),user.getPassword());
        Map<String, Object> map = new HashMap<>();
        if (userVo == null) {
            map.put("message", "登录失败...");
            map.put("code", -1);
            map.put("success", false);
        } else {
            //登录成功的时候给他创建token
            Map<String,Object> claim = new HashMap<>();
            claim.put("username", userVo.getUsername());
            claim.put("id", userVo.getId());
            String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 30);

            map.put("message", "登录成功...");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", userVo);
            map.put("token",token);
        }
        return map;
    }


    @RequestMapping("verifyToken")
    public Map<String, Object> verify(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("code", -1);
        map.put("message", "哈哈终于成功了");
        map.put("data", request.getAttribute("claim"));

        return map;
    }
}
