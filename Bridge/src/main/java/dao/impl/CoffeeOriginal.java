package dao.impl;

import dao.Coffee;
//原味咖啡
public class CoffeeOriginal implements Coffee {
    @Override
    public void orderCoffee(int count) {
        System.out.println("原味咖啡"+count+"杯");
    }
}

