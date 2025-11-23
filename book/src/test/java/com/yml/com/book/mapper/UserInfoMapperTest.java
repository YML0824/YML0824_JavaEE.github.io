package com.yml.com.book.mapper;

import com.yml.com.book.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 18:03
 */

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryUserInfoByName() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("admin");
        userInfoMapper.queryUserInfoByName(userInfo.getUserName());
    }
}