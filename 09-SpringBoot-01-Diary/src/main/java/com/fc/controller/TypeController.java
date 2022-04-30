package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("list")
    public ModelAndView list(Integer id, ModelAndView mv, HttpSession session){
        //获取域对象
        TbUser user= (TbUser) session.getAttribute("user");
        //获取域对象的id
        Integer userId = user.getId();

        List<TbNoteType>type = typeService.list(id,userId);

        mv.addObject("list",type);

        mv.addObject("menu_page",type);


        mv.addObject("changePage", "/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }
}
