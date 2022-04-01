package dao.impl;

import dao.Coffee;
//加糖类咖啡
public class CoffeeWithSugar implements Coffee {
    @Override
    public void orderCoffee(int count) {
        System.out.println("加糖类咖啡"+count+"杯");
    }
}
