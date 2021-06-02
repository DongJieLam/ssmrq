package com.rain.learn;

/**
 * 使用多线程练习——继承Thread,重写run方法
 */
public class MyThread01 extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("继承Thread使用多线程");
    }

    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        //调用start()方法启动线程
        myThread01.start();
        System.out.println("运行结束");
        /**
         * 运行的结果：
         * 运行结束
         * 继承Thread使用多线程
         *
         * 结果分析：为什么先打印出“运行结束”？而不是先打印“继承Thread使用多线程”？
         * 因为线程是异步处理。调用start()方法后，线程以随机的时间去执行run方法。
         * 所以调用start()方法后，就直接执行下一句代码，就是打印“运行结束”的代码。
         *
         * 总结：使用多线程可以异步处理，先将接收到请求返回给调用接口
         */
    }
}
