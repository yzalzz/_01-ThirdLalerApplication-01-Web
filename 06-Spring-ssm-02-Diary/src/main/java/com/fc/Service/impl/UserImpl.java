package com.fc.Service.impl;

import com.fc.Service.UserService;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public ModelAndView login( HttpServletRequest req,HttpServletResponse resp) throws IOException {
        ModelAndView mv = new ModelAndView();
        ResultVo resultVo;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ":" + password);
        HttpSession session = req.getSession(true);
        TbUser name = tbUserMapper.findByName(username);
        if (name == null) {
            resultVo = new ResultVo(400, "用户名不存在", false, null);
        } else {
            if (username.equals(name.getUsername()) && password.equals(name.getPassword())) {
                session.setAttribute("user", name);
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
                cookie.setMaxAge(30);
                resp.addCookie(cookie);
                mv.setViewName("/index.jsp");
                resultVo = new ResultVo(200, "登录成功", true, username);
            } else {
                session.setAttribute("resultInfo", null);
                mv.setViewName("/login.jsp");
                resultVo = new ResultVo(400, "用户名或密码错误", false, null);
            }
        }
        return mv;
    }
    @Override
    public Map<String,Object>checkNick(String username) {
        Map<String, Object> map = new HashMap<>();
        TbUser byName = tbUserMapper.findByName(username);
        System.out.println(username);
        System.out.println(byName.getUsername());
        if (username.equals(byName.getUsername())){
            map.put("查到了",0);
            return map;
        }else {
            map.put("没查到",1);
        }
        return map;
    }

    @Override
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();

        //获取session
        HttpSession session = req.getSession(false);
        //必须要加if判断 因为session可能那的是空 空值不能掉方法
        if (session!=null){
            //获取session的id
            String id = session.getId();
            session.removeAttribute("username");
            //销毁session
            session.invalidate();
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(0);
            resp.addCookie(cookie);


            mv.setViewName("/login.jsp");
        }

        return mv;
    }
}
