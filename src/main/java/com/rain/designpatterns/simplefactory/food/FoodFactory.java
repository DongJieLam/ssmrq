package com.rain.designpatterns.simplefactory.food;

import org.springframework.util.StringUtils;

public class FoodFactory {

    public static Food makeFood(String food){

        if("chicken".equalsIgnoreCase(food)){
            Food chicken = new Chicken();
            chicken.getFoodName();
            return chicken;
        }else if ("noodle".equalsIgnoreCase(food)){
            Food noodle = new Noddle();
            noodle.getFoodName();
            return new Noddle();
        }else if(StringUtils.isEmpty(food)){
            System.out.println("传入食物参数为空，无法生成食物");
            return null;
        }else{
            System.out.println("抱歉，本店没有这种食物。");
            return null;
        }
    }
}
