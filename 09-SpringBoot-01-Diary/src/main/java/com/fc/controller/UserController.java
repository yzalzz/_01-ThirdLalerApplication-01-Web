package com.fc.controller;

import com.fc.Vo.ResultVO;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller //不能用RestController 因为要走视图解析器
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    //  用户登录
    @PostMapping("login")
    public ModelAndView login(ModelAndView mv, TbUser user, Integer remember, HttpSession session, HttpServletResponse response) {
        //调用service层登录方法
        ResultVO resultVO = userService.login(user.getUsername(), user.getPassword());

        Cookie cookie;

        if (resultVO.getCode() == 200) {
            //登陆成功
            //resultVO.getData() 查出来的对象
            session.setAttribute("user", resultVO.getData());
            //勾选了记住我
            if (remember != null && remember == 1) {
                //
                cookie = new Cookie("JSESSIONID", session.getId());

                //设置过期时间
                cookie.setMaxAge(30 * 60);


            } else {
                //没勾选

                cookie = new Cookie("JSESSIONID", "");

                //负数代表浏览器关闭是销毁
                cookie.setMaxAge(-1);

            }
            response.addCookie(cookie);

            //跳转页面
            mv.setViewName("redirect:/index.jsp");
        } else {
            //登陆失败
            mv.addObject("resultInfo", resultVO);

            mv.setViewName("redirect:/login.jsp");
        }

        return mv;

    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        //销毁Session
        request.removeAttribute("user");

        Cookie cookie = new Cookie("JSESSIONID", "");

        cookie.setMaxAge(0);

        response.addCookie(cookie);

        mv.setViewName("redirect:/login.jsp");

        return mv;
    }
    @GetMapping("userCenter")
    public ModelAndView userCenter(ModelAndView mv,HttpSession session){
        TbUser user= (TbUser) session.getAttribute("user");
        session.setAttribute("menu_page",user);
//      session.setAttribute("changePage",user);
        mv.addObject("changePage", "/user/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update( MultipartFile img ,TbUser tbUser,ModelAndView mv,HttpSession session){
        ResultVO resultVO=userService.update(img,tbUser);
        if (resultVO.getCode()==200){
            session.setAttribute("User",resultVO.getData());
        }
        mv.setViewName("forward:/user/userCenter");
        return mv;
    }
    @GetMapping("checkNick")
    public Map<String,Object> checkNick(String username){
      return userService.checkNick(username);

    }
}
