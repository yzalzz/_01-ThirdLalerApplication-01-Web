package com.fc.service;

import com.fc.entity.Collection;

import java.util.List;
import java.util.Map;

public interface CollectService {






    Map<String, Object> list(Integer pageNum,Integer pageSize);

    Map<String, Object> del(Collection id);

    Map<String, Object> add(Collection collection);
}
