package com.rain.designpatterns.simplefactory.tv;

public class TVFactory {

    public static TV produceTV(String brandName) throws Exception{

        if("Haier".equalsIgnoreCase(brandName)){
            System.out.println("电视机工厂生产海尔电视");
            return new HaierTV();
        }else if("XiaoMi".equalsIgnoreCase(brandName)){
            System.out.println("电视机工厂生产小米电视");
            return new XiaoMiTV();
        }else{
            throw new Exception("抱歉，暂不能生产该品牌电视");
        }

    }
}
