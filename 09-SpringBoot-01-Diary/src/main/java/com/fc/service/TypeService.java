package com.fc.service;

import com.fc.entity.TbNoteType;

import java.util.List;

public interface TypeService {


    List<TbNoteType> list(Integer id, Integer userId);
}
