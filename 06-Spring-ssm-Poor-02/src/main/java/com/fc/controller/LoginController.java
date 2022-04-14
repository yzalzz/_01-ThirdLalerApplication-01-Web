package com.fc.controller;

import com.fc.service.LoginService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin("/*")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("login")
    public ResultVo checkUser(String username, String password){
        System.out.println(username);
        return loginService.checkUser(username,password);
    }
    @RequestMapping("verifyToken")
    public ResultVo verify(HttpServletRequest request) {
        ResultVo resultVo=null;
        resultVo=new ResultVo(200,"验证成功",true,request.getAttribute("claim"));
        return resultVo;
    }
}
