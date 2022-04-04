package com.fc.service;

import com.fc.entity.Alleviation;

import java.util.Date;
import java.util.Map;

public interface PolicyService {
    Map<String, Object> click(Long id, Date lastClickTime);

    Map<String, Object> list(Integer pageNum,Integer pageSize);

    Map<String, Object> add(Alleviation alleviation);

    Map<String, Object> update(Alleviation alleviation);

    Map<String, Object> del(Alleviation id);

}
