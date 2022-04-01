package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    //controller 要依赖与service层
    private TbMusicService tbMusicService;
    @RequestMapping("findAll")
   public List<TbMusic>findAll(){
        return tbMusicService.findAll();
    }
}
