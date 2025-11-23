package com.yml.springblog.controller;

import com.yml.springblog.pojo.request.UserLoginRequest;
import com.yml.springblog.pojo.response.UserInfoResponse;
import com.yml.springblog.pojo.response.UserLoginResponse;
import com.yml.springblog.service.UserService;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:26
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @RequestMapping("/login")
    public UserLoginResponse login(@RequestBody @Validated UserLoginRequest userLoginRequest) {
        log.info("用户登录，用户名：" +userLoginRequest.getUserName());
        return userService.checkPassword(userLoginRequest);
    }


    @RequestMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull(message = "userId不能为空") Integer userId) {
        log.info("获取用户信息，userId:"+userId);
        return userService.getUserInfo(userId);
    }

    @RequestMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull(message = "blogId不能为空") Integer blogId) {
        log.info("获取用户信息，blogId:"+blogId);
        return userService.getAuthorInfo(blogId);
    }
}
