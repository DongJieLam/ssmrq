package com.rain.designpatterns.simplefactory.tv;

public class XiaoMiTV implements TV{
    @Override
    public void play() {
        System.out.println("小米电视");
    }
}
