package com.yml.mybaits.controller;

import com.yml.mybaits.model.UserInfo;
import com.yml.mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-25
 * Time: 15:11
 */

@RequestMapping("/user")
@RestController
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public List<UserInfo> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/getUserInfoById")
    public UserInfo getUserInfoById(Integer id){
        return userService.getUserInfoById(id);
    }

    @RequestMapping("/getUserInfoById2")
    public List<UserInfo> getUserInfoById2(Integer id){
        return userService.getUserInfoById2(id);
    }


    /*
     * @author MartinYang
     * @date 2025-10-28 19:22
     * 登录接口
     * @params:
     * @returns: boolean
     */
    @RequestMapping("/login")
    public boolean login(String userName, String password){
        UserInfo userInfo = userService.queryUserByUserNameAndPassword(userName, password);
        return userInfo == null ? false : true;
    }



}
