//package com.fc.controller;
//
//import com.fc.entity.Collection;
//import com.fc.service.CollectService;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import jdk.internal.org.objectweb.asm.Handle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("collect")
//public class CollectController {
//    //
//    @Autowired
//    private CollectService collectService;
//    @RequestMapping("list")
//    public Map<String,Object> list(){
//        List<Collection> list = collectService.list();
//        PageHelper.startPage(1,5);
//        PageInfo<Collection> PageInfo = new PageInfo<>(list);
//        Map<String, Object> map = new HashMap<>();
//
//        if (list==null){
//            map.put("message","用户获取失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//            return map;
//        }else {
//                map.put("message","用户获取成功");
//                map.put("code",200);
//                map.put("success:",true);
//                map.put("data",PageInfo);
//
//        }
//        return map;
//    }
//
//    @RequestMapping("add")
//    public Map<String,Object> add(Collection collection){
//        HashMap<String, Object> map = new HashMap<>();
//        if (collectService.add(collection)!=1){
//            map.put("message","收藏失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//        }else {
//            map.put("message","收藏成功");
//            map.put("code",200);
//            map.put("success:",true);
//            map.put("data","");
//        }
//        return map;
//    }
//    @RequestMapping("del")
//    public Map<String,Object> del(Collection id){
//        Map<String, Object> map = new HashMap<>();
//        if (collectService.del(id)!=1){
//            map.put("message","删除失败");
//            map.put("code",400);
//            map.put("success:",false);
//            map.put("data","errMsg:错误描述");
//            return map;
//        }
//        else {
//            map.put("message","删除成功");
//            map.put("code",200);
//            map.put("success:",true);
//            map.put("data","");
//        }
//            return map;
//    }
//}
