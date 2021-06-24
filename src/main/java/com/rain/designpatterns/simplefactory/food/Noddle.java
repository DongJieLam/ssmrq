package com.rain.designpatterns.simplefactory.food;

public class Noddle implements Food{

    @Override
    public void getFoodName() {
        System.out.println("面条");
    }
}
