package com.rain.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MyThread02 implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口使用多线程");
    }

    public static void main(String[] args) {
      /*  Runnable runnable = new MyThread01();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");*/
       /* String s = "123456";
        System.out.println(s);
        s.replace("1","0");
        System.out.println(s);
        s = s.replace("2","0");
        System.out.println(s);*/

        /*HashMap<String,String> map = new HashMap<>();
        map.put("1","2");
        String result = map.put("1","3");
        //result返回什么？ 返回的是2 不是 3，因为put方法有返回值，如果key重复，返回的是old value,
        System.out.println(result);
        String result2 = map.put("2","4");
        System.out.println(result2);

        Hashtable hashTable = new Hashtable<String,String>();*/


       /* List list = new ArrayList<>();
        if(list.isEmpty()){
            System.out.println("list为空");
        }
        list = null;
        if(list.isEmpty()){
            System.out.println("list为空");
        }
        if(list!=null && list.size()>0){
            System.out.println("list不为空！");
        }*/

        int[] arr = new int[]{1,2,3,4};
        //指定集合list 的容量大小
        List<Integer> list = new ArrayList<>(arr.length);
        int size1 = list.size();

        for (int i : arr){
            list.add(i);
        }
        int size = list.size();
        list.add(5);
        list.add(6);
    }
}
