package com.rain.learn;

import com.rain.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    private static List<User> userList = new ArrayList<>();

    static{
        userList.add(new User(1,"张三","管理员"));
        userList.add(new User(2,"李四","客户经理"));
        userList.add(new User(3,"王五","管理员"));
        userList.add(new User(4,"赵六","业务员"));
    }

    /**
     * 统计客户经理数  普通for循环写法
     * @return
     */
    public int countManagerNum(){
        List<User> managerList = new ArrayList<>();
        for(User user : userList){
            if ("客户经理".equals(user.getRole())) {
                managerList.add(user);
            }
        }

        return managerList.size();
    }

    /**
     * 统计客户经理数  使用java8的Stream流写法
     * @return
     */
    public int countManagerNumStream(){
        List<User> managerList = userList.stream()
                .filter(apple -> ("管理员").equals(apple.getRole()))
                .collect(Collectors.toList());
        return managerList.size();
    }

    /**
     * 统计id大于3的客户经理
     * 使用Stream但是条件加多一个 id 大于3
     * 只需要加多一个filter
     * @return
     */
    public int countManagerNumIDThan3(){
        List<User> managerList = userList.stream()
                .filter(user -> ("业务经理").equals(user.getRole()))
                .filter(user -> user.getId() > 3)
                .collect(Collectors.toList());
        return managerList.size();
    }

    /**
     * 根据条件统计用户数
     * @param predicate
     */
    public int countUserNum(Predicate<? super User> predicate){
        return userList.stream().filter(predicate).collect(Collectors.toList()).size();
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        System.out.println(demo.countManagerNum());
        System.out.println(demo.countManagerNumStream());
        System.out.println(demo.countUserNum(user -> "客户经理".equals(user.getRole())
                && user.getId() > 1 && "李".equals(user.getUsername().substring(0, 1))));
    }

}
