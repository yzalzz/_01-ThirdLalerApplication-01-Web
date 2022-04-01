package com.fc.test;

import com.fc.Abstract.Shape;
import com.fc.dao.impl.GreenCircle;
import com.fc.dao.impl.RedCircle;
import com.fc.entity.Circle;

public class DrawTest {
    public static void main(String[] args) {
        Shape redCircle=new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(10,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

