package com.rain.controller;

import com.rain.common.CommonResult;
import com.rain.model.User;
import com.rain.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(value = "用户管理", tags={"用户管理接口"})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("获取所有用户")
    @GetMapping("/")
    public @ResponseBody CommonResult<List<User>> queryAll(){
        LOGGER.info("开始查询所有用户");
        List<User> userList = new ArrayList<>();
        userList = userService.queryAll();
        LOGGER.info("结束查询所有用户，用户总共有 " + userList.size());
        return CommonResult.success(userList);
    }

    @ApiOperation("新增用户")
    @PostMapping("/")
    public CommonResult insertUser(@RequestBody User user){
        CommonResult commonResult;
        int count = userService.insertUser(user);
        if(count != 1){
            commonResult = CommonResult.failed("新增失败");
        }else{
            commonResult = CommonResult.success(count);
        }
        return commonResult;
    }

    @ApiOperation("新增用户02")
    @RequestMapping(value = "/insert/user",method = RequestMethod.POST)
    public CommonResult insertUser02(@RequestBody User user){
        CommonResult commonResult;
        int count = userService.insertUser(user);
        if(count != 1){
            commonResult = CommonResult.failed("新增失败");
        }else{
            commonResult = CommonResult.success(count);
        }
        return commonResult;
    }

    @ApiOperation("获取单个用户")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public CommonResult queryUserById(@PathVariable("id") int id){
        CommonResult commonResult;
        User user = userService.queryUserById(id);
        if(user == null){
            commonResult = CommonResult.failed("操作失败");
        }else{
            commonResult = CommonResult.success(user);
        }
        return commonResult;
    }

    @ApiOperation("修改用户")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CommonResult updateUserById(@PathVariable("id") int id, @RequestBody User user){
        CommonResult commonResult;
        int count = userService.updateUserById(id,user);
        if(count != 1){
            commonResult = CommonResult.failed("操作失败");
        }else{
            commonResult = CommonResult.success(count);
        }

        return commonResult;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteUser(@PathVariable("id") int id){
        CommonResult commonResult;
        int count =  userService.deleteUser(id);
        if(count != 1){
            commonResult = CommonResult.failed("新增失败");
        }else{
            commonResult = CommonResult.success(count);
        }
        return commonResult;
    }

    @ApiOperation("获取分页用户")
    @RequestMapping(value = "/query/page", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<User>> queryUserByPage(@RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize){
        return CommonResult.success(userService.queryUserByPage(page,pageSize));

    }


    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user, HttpSession session) throws Exception {
        CommonResult<User> commonResult = userService.login(user);
        if("200".equals(commonResult.getCode())){
            session.setAttribute("currentUser", commonResult.getData());
        }
        return commonResult;
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody User user) {
       return userService.register(user);
    }
}
