package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("music")
public class TbMusicController {
   @RequestMapping("findAll")
    public List<String> findAll(){
       ArrayList<String > list = new ArrayList<>();
       list.add("11");
       list.add("2");
       return list;
   }
}
