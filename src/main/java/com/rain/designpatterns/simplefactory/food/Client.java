package com.rain.designpatterns.simplefactory.food;

public class Client {
    public static void main(String[] args) {
        Food food = FoodFactory.makeFood("noodle");
    }
}
