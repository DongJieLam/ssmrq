package com.rain.learn;

public class MyThread03 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread");
    }

    public static void main(String[] args) {
        new Thread(new MyThread03()).start();

        //Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
