package com.fc.dao.impl;

import com.fc.dao.Draw;

public class GreenCircle implements Draw {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("绿圆 :radius="+radius+"x="+x+"y="+y);
    }
}
