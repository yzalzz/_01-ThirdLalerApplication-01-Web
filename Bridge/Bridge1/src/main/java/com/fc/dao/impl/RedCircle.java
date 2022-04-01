package com.fc.dao.impl;

import com.fc.dao.Draw;

public class RedCircle implements Draw {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("红圆 :radius="+radius+"x="+x+"y="+y);
    }
}
