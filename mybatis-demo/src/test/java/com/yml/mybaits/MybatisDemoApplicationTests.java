package com.yml.mybaits;

import com.yml.mybaits.mapper.UserInfoMapper;
import com.yml.mybaits.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    private ApplicationContext context;
    @Test
    void contextLoads() {
        UserInfoMapper bean = context.getBean(UserInfoMapper.class);
        //下面注释的和foreach循环写的是等价的
        //bean.selectAll().stream().forEach(x -> System.out.println(x));
        List<UserInfo> userInfos = bean.selectAll();
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
        List<UserInfo> collect = userInfos.stream().filter(x -> x.getGender() == 1).collect(Collectors.toList());
    }
    @Test
    void contextLoads2() {
        UserInfoMapper bean = context.getBean(UserInfoMapper.class);
        bean.selectAll().stream().forEach(x -> System.out.println(x));
    }
    @Test
    void contextLoads3() {
        UserInfoMapper bean = context.getBean(UserInfoMapper.class);
        bean.selectAll().stream().forEach(x -> System.out.println(x));
    }

}
