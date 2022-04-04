package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.entity.User;
import com.fc.service.CollectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectionMapper collectionMapper;


    @Override
    public Map<String,Object> list(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Collection> list = collectionMapper.selectByExample(null);
        PageInfo<Collection> collectionPageInfo = new PageInfo<>(list);
        Map<String , Object> map = new HashMap<>();
        if (list==null){
            map.put("message","用户获取失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","用户获取成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data",collectionPageInfo.getList());
            map.put("data",collectionPageInfo);
        }
        return map;
    }

    @Override
    public Map<String,Object>add(Collection collection) {
        collection.setCreateTime(new Date());
        collection.setUserId(8L);
        collection.setRefId(8L);
        collection.setTableName("舔狗");
        collection.setName("孟志斌");
        collection.setPicture("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Falcdn.img.xiaoka.tv%2F20200511%2Fe26%2F79f%2F10173657%2Fe2679fe0a461214cefc8597f70780390.jpg%401e_1c_0o_0l_600h_800w_90q_1pr.jpg&refer=http%3A%2F%2Falcdn.img.xiaoka.tv&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651288944&t=071a9e114f658449bdc5405879539089");
        collection.setType("加油");
        collection.setRecommendType("蹲坑");
        HashMap<String, Object> map = new HashMap<>();
        if (collectionMapper.insert(collection)!=1){
            map.put("message","收藏失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
        }else {
            map.put("message","收藏成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;

    }
    @Override
    public Map<String,Object> del(Collection id) {
        Map<String, Object> map = new HashMap<>();
        if (collectionMapper.deleteByPrimaryKey(id)!=1){
            map.put("message","删除失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }
        else {
            map.put("message","删除成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }
}
