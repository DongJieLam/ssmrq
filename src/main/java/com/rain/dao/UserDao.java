package com.rain.dao;

import com.rain.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

     List<User> queryAll();

     int insertUser(User user);

     User queryUserById(int id);

     int updateUserById(User user);

     int deleteUser(int id);

     List<User> queryUserByPage(@Param("page") int page, @Param("pageSize") int pageSize);

     int checkUserName(String userName);

     User checkPassword(@Param("username") String username, @Param("password") String password);
}
