package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
}
