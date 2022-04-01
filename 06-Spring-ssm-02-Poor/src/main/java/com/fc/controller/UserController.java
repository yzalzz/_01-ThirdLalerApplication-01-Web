//package com.fc.controller;
//
//import com.fc.entity.User;
//import com.fc.service.UserService;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("user")
//public class UserController {
//    //controller层调用service层
//    @Autowired
//    private UserService userService;
//    @RequestMapping("list")
//    public Map<String,Object>list(){
//        List<User> list = userService.list();
//        //开启分页
//        PageHelper.startPage(1,2);
//        PageInfo<User> userPageInfo = new PageInfo<>(list);
//        System.out.println(userPageInfo);
//        HashMap<String , Object> map = new HashMap<>();
//        if (list==null){
//            map.put("message","用户获取失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//            return map;
//        }else {
//            map.put("message","用户获取成功");
//            map.put("code",200);
//            map.put("success:",true);
//            map.put("data",userPageInfo);
//        }
//        return map;
//    }
//    @RequestMapping("del")
//    public Map<String,Object> del(Long id){
//       Map<String , Object> map = new HashMap<>();
//        if(userService.del(id) !=1){
//            map.put("message","用户删除失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//            return map;
//        }else {
//            map.put("message","用户删除成功");
//            map.put("code",200);
//            map.put("success:",true);
//            map.put("data","");
//        }
//        return map;
//    }
//    @RequestMapping("updata")
//    public Map<String,Object> updata(User user){
//        Map<String, Object> map = new HashMap<>();
//        if (userService.updata(user) !=1){
//            map.put("message","用户改变失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//            return map;
//        }else {
//            map.put("message","用户改变成功");
//            map.put("code",200);
//            map.put("success:",true);
//            map.put("data","");
//        }
//       return map;
//    }
//    @RequestMapping("add")
//    public Map<String ,Object> add(User user) {
//        Map<String, Object> map = new HashMap<>();
//        if (userService.add(user) != 1) {
//            map.put("message", "用户添加失败");
//            map.put("code", 400);
//            map.put("success:", false);
//            map.put("data", "errMsg:错误描述");
//        } else {
//            map.put("message", "用户添加成功");
//            map.put("code", 200);
//            map.put("success:", true);
//            map.put("data", "");
//        }
//        return map;
//    }
//}
