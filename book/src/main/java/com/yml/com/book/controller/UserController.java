package com.yml.com.book.controller;

import com.yml.com.book.constant.Constants;
import com.yml.com.book.model.UserInfo;
import com.yml.com.book.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-15
 * Time: 21:08
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){

        log.info("用户登录：name:{}",userName);

        //1.参数校验
        //2.校验账号和密码是否正确
        //3.设置session
        //4.返回结果
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //根据用户名获取用户信息
        UserInfo userInfo =userInfoService.queryUserInfoByName(userName);

        if(userInfo==null){
            return false;
        }
        if (password.equals(userInfo.getPassword())) {
            userInfo.setPassword(" ");
            session.setAttribute(Constants.SESSION_USER_KEY,userInfo);
            return true;
        }

        return false;

    }
}
