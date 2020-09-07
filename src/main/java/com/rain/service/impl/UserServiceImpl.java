package com.rain.service.impl;

import com.rain.common.CommonResult;
import com.rain.dao.UserDao;
import com.rain.model.User;
import com.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public int updateUserById(int id, User user) {
        user.setId(id);
        return userDao.updateUserById(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> queryUserByPage(int page, int pageSize) {
        return userDao.queryUserByPage((page-1)*pageSize,pageSize);
    }

    @Override
    public CommonResult<User> login(User user) {
        int count = userDao.checkUserName(user.getUsername());
        if(count == 0){
            return CommonResult.failed("用户不存在");
        }

        User userResult = userDao.checkPassword(user.getUsername(),user.getPassword());
        if(userResult == null){
            return CommonResult.failed("密码错误");
        }
        userResult.setPassword("");

        return CommonResult.success(userResult, "登录成功");
    }

    @Override
    public CommonResult register(User user) {
        int checkUsernameCount = userDao.checkUserName(user.getUsername());
        if(checkUsernameCount != 0){
            return CommonResult.failed("用户名已存在");
        }

        int registResult = userDao.insertUser(user);
        if(registResult == 1){
            return CommonResult.success(registResult,"注册成功");
        }else{
            return CommonResult.failed("注册失败");
        }

    }


}
