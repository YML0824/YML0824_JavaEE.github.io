package com.yml.mybaits.mapper;

import com.yml.mybaits.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-26
 * Time: 17:02
 */
@SpringBootTest
class UserInfoMapperXMLTest {

    @Autowired
    private  UserInfoMapperXML userInfoMapperXML;

    @Test
    void selectAll() {

        System.out.println(userInfoMapperXML.selectAll());

    }

    @Test
    void selectAll2() {
        System.out.println(userInfoMapperXML.selectAll2());
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("杨木霖");
        userInfo.setPassword("123456");
        userInfo.setAge(22);
        userInfoMapperXML.insertUser(userInfo);
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("刘巧漫3");
        userInfo.setPassword("123456777");
        userInfo.setAge(21);
        System.out.println("影响行数："+userInfoMapperXML.insertUser2(userInfo) + " id :"+ userInfo.getId());
    }


    @Test
    void updateUser1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("刘巧漫4");
        userInfo.setId(13);
        userInfoMapperXML.updateUser1(userInfo);
    }

    @Test
    void updateUser2() {
        userInfoMapperXML.updateUser2("updatePassword5",18,16);
    }

    @Test
    void deleteUser() {
        userInfoMapperXML.deleteUser(16);
    }

    @Test
    void deleteByNameAge() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("刘巧漫4");
        userInfo.setAge(21);
        userInfoMapperXML.deleteByNameAge(userInfo);
    }

    @Test
    void insertUser3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("liuqaoman8");
        userInfo.setPassword("123456777");
        userInfo.setAge(6);
        userInfo.setGender(1);
//        userInfo.setPhone("1008611");
        System.out.println("影响行数："+userInfoMapperXML.insertUser3(userInfo) + " id :"+ userInfo.getId());
    }

    @Test
    void selectByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone("1008611");
        userInfo.setDeleteFlag(1);
        userInfoMapperXML.selectByCondition(userInfo).stream().forEach(x-> System.out.println(x));
    }

    @Test
    void updateByCondition() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(32);
        userInfo.setPassword("123455555");
//        userInfo.setAge(21);
        userInfo.setGender(1);
        userInfoMapperXML.updateByCondition(userInfo);
    }

    @Test
    void batchDelete() {
        List<Integer> ids = List.of(25,25,26);
        userInfoMapperXML.batchDelete(ids);

    }
}