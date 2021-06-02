package com.rain.util;

import com.rain.annotation.MyAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class TestAnnotation {

    @MyAnnotation
    public void test(){
        System.out.println("啊哈");
    }

    public static void main(String[] args) {
//        TestAnnotation testAnnotation = new TestAnnotation();
//        testAnnotation.test();

        try {
            //反射
            Class<?> classTestAnnotation = Class.forName("com.rain.util.TestAnnotation");
            System.out.println(classTestAnnotation.getPackage());
            Method methodTestAnnotation = classTestAnnotation.getDeclaredMethod("test");
            methodTestAnnotation.setAccessible(true);
            Object objectTestAnnotation = classTestAnnotation.newInstance();
            methodTestAnnotation.invoke(objectTestAnnotation);

            //通过反射获取注解的属性
            boolean isPresent = methodTestAnnotation.isAnnotationPresent(MyAnnotation.class);
            if(isPresent){
                MyAnnotation annotation = methodTestAnnotation.getAnnotation(MyAnnotation.class);
                System.out.println(annotation.value());
            }

            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
