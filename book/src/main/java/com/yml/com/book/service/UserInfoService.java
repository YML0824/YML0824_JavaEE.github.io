package com.yml.com.book.service;

import com.yml.com.book.mapper.UserInfoMapper;
import com.yml.com.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 17:38
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserInfoByName(String userName) {
        return userInfoMapper.queryUserInfoByName(userName);
    }

}
