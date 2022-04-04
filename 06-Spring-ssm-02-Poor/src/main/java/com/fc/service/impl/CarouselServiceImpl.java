package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.entity.CarouselExample;
import com.fc.service.CarouselService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarouselServiceImpl implements CarouselService {
@Autowired
    private CarouselMapper carouselMapper;
    @Override
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Carousel> list = carouselMapper.selectByExample(null);
        PageInfo<Carousel> pageInfo = new PageInfo<>(list);
        if (list!=null){
            map.put("message","用户获取成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data",pageInfo.getList());
            map.put("data",pageInfo);
            return map;
        }else {
            map.put("message","用户获取失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
        }
        return map;
    }

    @Override
    public Map<String, Object> add(Carousel carousel) {
        HashMap<String, Object> map = new HashMap<>();
        carousel.setName("加油");
        carousel.setPicture("http://www.cnfpzz.com/upload/other/image/20211229164073908810.jpg");
        carousel.setAvailable(true);
        carouselMapper.insert(carousel);
        if (carouselMapper.insert(carousel)!=1){
            map.put("message","添加失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","添加成功");
            map.put("code",200);
            map.put("success:",false);
            map.put("data","");

        }
        return map;
    }

    @Override
    public Map<String, Object> del(Carousel id) {
        HashMap<String, Object> map = new HashMap<>();
        if (carouselMapper.deleteByPrimaryKey(6)!=1){
            map.put("message","删除失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","删除成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }

    @Override
    public Map<String, Object> update(Carousel carousel) {
        Map<String, Object> map = new HashMap<>();
        carousel.setId(7);
        carousel.setName("jjjj");
        carouselMapper.updateByPrimaryKey(carousel);
        if (carouselMapper.updateByPrimaryKey(carousel)!=1){
            map.put("message","用户改变失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","用户改变成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");
        }
        return map;
    }

    @Override
    public Map<String, Object> state(Carousel id) {
        HashMap<String, Object> map = new HashMap<>();
        if (carouselMapper.state(id)!=1){
            map.put("message","设置失败");
            map.put("code",400);
            map.put("success:",false);
            map.put("data","errMsg:错误描述");
            return map;
        }else {
            map.put("message","设置成功");
            map.put("code",200);
            map.put("success:",true);
            map.put("data","");

        }
        return map;
    }

}
