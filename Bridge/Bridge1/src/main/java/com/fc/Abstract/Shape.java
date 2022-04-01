package com.fc.Abstract;

import com.fc.dao.Draw;

//使用Draw接口创建一个抽象类
public abstract class Shape {
    protected Draw draw;
    protected Shape(Draw draw){
        this.draw=draw;
    }
    public abstract void draw();
}
