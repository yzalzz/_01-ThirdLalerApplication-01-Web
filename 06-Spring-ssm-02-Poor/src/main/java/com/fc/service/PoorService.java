package com.fc.service;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;

import java.util.Date;
import java.util.Map;

public interface PoorService {
    Map<String, Object> list(Integer pageNum, Integer pageSize,String username);

    Map<String, Object> add(Poor poor);

    Map<String, Object> update(Poor poor);


    Map<String, Object> del(Poor id);

    Map<String, Object> click(Long id,Date lastClickTime);

}
