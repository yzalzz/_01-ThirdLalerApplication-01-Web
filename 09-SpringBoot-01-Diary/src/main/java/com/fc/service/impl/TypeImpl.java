package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;


    @Override
    public List<TbNoteType> list(Integer id, Integer userId) {
        TbNoteTypeExample tbNoteTypeExample = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = tbNoteTypeExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return list(userId,id);

    }
}
