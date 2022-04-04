package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
   @Autowired
   private CarouselService carouselService;

   @RequestMapping("list")
   public Map<String, Object> list(Integer pageNum , Integer pageSize) {
      return carouselService.list(pageNum,pageSize);
   }
   @RequestMapping("add")
  public Map<String,Object> add(Carousel carousel){
      return carouselService.add(carousel);
  }
  @RequestMapping("del")
  public Map<String ,Object>del(Carousel id){
       return carouselService.del(id);
  }
  @RequestMapping("update")
  public Map<String,Object>update(Carousel carousel){
       return carouselService.update(carousel);
  }
  @RequestMapping("state")
  public Map<String,Object> state(Carousel id){
       return carouselService.state(id);
  }
   }

