package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;

import java.util.List;

public class TbMusicServiceImpl implements TbMusicService {
    //service依赖于dao
    private TbMusicMapper tbMusicMapper;

    @Override
    public List<TbMusic> findAll() {

        return tbMusicMapper.selectByExample(null);
    }
}
