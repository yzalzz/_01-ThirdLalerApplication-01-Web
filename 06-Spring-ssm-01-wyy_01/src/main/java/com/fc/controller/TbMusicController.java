package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;
import com.fc.service.impl.TbMusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    @Autowired
   private TbMusicService tbMusicService;
    @RequestMapping("findAll")
    public List<TbMusic> findAll(){
       return tbMusicService.findAll();
    }
}
