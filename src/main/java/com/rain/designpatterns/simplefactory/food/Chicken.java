package com.rain.designpatterns.simplefactory.food;

public class Chicken implements Food{

    @Override
    public void getFoodName() {
        System.out.println("鸡肉");
    }
}
