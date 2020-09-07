package com.rain.service;

import com.rain.common.CommonResult;
import com.rain.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {

     List<User> queryAll();

     int insertUser(User user);

     User queryUserById(int id);

     int updateUserById(int id, User user);

     int deleteUser(int id);

     List<User> queryUserByPage(int page, int pageSize);

     CommonResult<User> login(User user);
}
