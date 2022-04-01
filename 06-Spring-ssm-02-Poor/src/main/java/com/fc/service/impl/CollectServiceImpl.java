//package com.fc.service.impl;
//
//import com.fc.dao.CollectionMapper;
//import com.fc.entity.Collection;
//import com.fc.entity.User;
//import com.fc.service.CollectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class CollectServiceImpl implements CollectService {
//    @Autowired
//    private CollectionMapper collectionMapper;
//
//
//    @Override
//    public List<Collection> list() {
//        return collectionMapper.selectByExample(null);
//    }
//
//    @Override
//    public int add(Collection collection) {
//        collection.setCreateTime(new Date());
//        collection.setUserId(8L);
//        collection.setRefId(8L);
//        collection.setTableName("舔狗");
//        collection.setName("孟志斌");
//        collection.setPicture("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Falcdn.img.xiaoka.tv%2F20200511%2Fe26%2F79f%2F10173657%2Fe2679fe0a461214cefc8597f70780390.jpg%401e_1c_0o_0l_600h_800w_90q_1pr.jpg&refer=http%3A%2F%2Falcdn.img.xiaoka.tv&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651288944&t=071a9e114f658449bdc5405879539089");
//        collection.setType("加油");
//        collection.setRecommendType("蹲坑");
//        int insert = collectionMapper.insert(collection);
//        return collectionMapper.insert(collection);
//    }
//
//    @Override
//    public int del(Collection id) {
//        return collectionMapper.deleteByPrimaryKey(7L) ;
//    }
//}
