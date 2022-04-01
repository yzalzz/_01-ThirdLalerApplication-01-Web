package dao.impl;

import dao.Coffee;

public class ZhongCoffeeWithSugar implements Coffee {
    @Override
    public void orderCoffee(int count) {
        System.out.println("中杯加糖类咖啡"+count+"杯");
    }
}
