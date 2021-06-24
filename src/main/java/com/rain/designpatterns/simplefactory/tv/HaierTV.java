package com.rain.designpatterns.simplefactory.tv;

public class HaierTV implements TV{
    @Override
    public void play() {
        System.out.println("海尔电视");
    }
}
