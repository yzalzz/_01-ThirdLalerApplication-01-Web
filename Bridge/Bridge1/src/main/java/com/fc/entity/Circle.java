package com.fc.entity;

import com.fc.Abstract.Shape;
import com.fc.dao.Draw;

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, Draw draw) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        draw.drawCircle(radius,x,y);
    }
}
