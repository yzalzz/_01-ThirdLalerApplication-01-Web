package dao.impl;

import dao.Coffee;

public class LargeCoffeeWithSugar implements Coffee {
    @Override
    public void orderCoffee(int count) {
        System.out.println("大杯加糖咖啡"+count+"杯");
    }
}
