//package com.fc.service.impl;
//
//import com.fc.dao.UserMapper;
//import com.fc.entity.User;
//import com.fc.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public int updata(User user) {
//        user.setId(6L);
//        user.setUsername("1111");
//        user.setPassword("88888");
//        userMapper.updateByPrimaryKey(user);
//        return userMapper.updateByPrimaryKey(user);
//    }
//
//
//
//    @Override
//    public List<User> list() {
//        return userMapper.selectByExample(null);
//    }
//
//    @Override
//    public int del(Long id) {
//        return userMapper.deleteByPrimaryKey(id);
//    }
//    @Override
//    public int add(User user) {
//        user.setCreateTime(new Date());
//        user.setUsername("龟田啊孟");
//        user.setPassword("123456");
//        user.setName("孟志斌");
//        user.setAge("85");
//        user.setGender("未知");
//        user.setPhone("15896930988");
//        user.setEmail("898968989@qq.com");
//        user.setPhoto("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20101108%2F20101108160056-1620231282.jpg&refer=http%3A%2F%2Fpic.baike.soso.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651288501&t=4ec4cb4b1bb192e8588d0f6252ab719a");
//        userMapper.insert(user);
//        return userMapper.insert(user);
//    }
//
//}
