package com.fc.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fc.Vo.UserVo;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.util.JwtUtil;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

@RestController//此注解跳过视图解析器
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public Map<String ,Object> login(User user){
        UserVo vo = userService.login(user.getUsername(), user.getPassword());

        Map<String, Object> map = new HashMap<>();

        if (vo == null) {
            map.put("message", "登录失败...");
            map.put("code", -1);
            map.put("success", false);
        } else {
            Map<String, Object> claim = new HashMap<>();

            claim.put("username", vo.getUsername());
            claim.put("id", vo.getId());

            String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 10);

            map.put("message", "登录成功...");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", vo);
            map.put("token", token);
        }

        return map;
    }
    @RequestMapping("verifyToken")
    public Map<String,Object> verifyToken(String token){
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", -1);

        if (token == null) {
            map.put("message", "token不存在");
        }

        try {
            Map<String, Object> claim = JwtUtil.getClaim(token);

            map.put("code", 200);
            map.put("message", "token验证成功");
            map.put("success", true);
            map.put("data", claim);
        } catch (AlgorithmMismatchException e) {
            map.put("message", "算法不匹配");
        } catch (InvalidClaimException e) {
            map.put("message", "非法载荷");
        } catch (SignatureVerificationException e) {
            map.put("message", "签名验证失败");
        } catch (TokenExpiredException e) {
            map.put("message", "token已过期");
        } catch (Exception e) {
            map.put("message", "token发生异常");
        }

        return map;
    }
}
