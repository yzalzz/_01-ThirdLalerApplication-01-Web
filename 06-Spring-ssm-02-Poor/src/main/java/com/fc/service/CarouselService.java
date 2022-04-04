package com.fc.service;

import com.fc.entity.Carousel;

import java.util.Map;

public interface CarouselService {

    Map<String, Object> list(Integer pageNum,Integer pageSize);



    Map<String, Object> add(Carousel carousel);

    Map<String, Object> del(Carousel id);

    Map<String, Object> update(Carousel carousel);

    Map<String, Object> state(Carousel id);
}
