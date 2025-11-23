package com.yml.mybaits.mapper;

import com.yml.mybaits.model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-24
 * Time: 19:24
 *  @SpringBootTest 测试环境使用这个进行启动
 *  @Autowired 这个注解之所以可以注入进来，原因是@SpringBootTest起的作用
 *  表示的是加载spring的运行环境，可以理解为它把spring启动起来了
 *  测试如果要使用spring的运行环境，比如注入某个Bean
 *  就需要加@SpringBootTest，不需要就不用加
 */
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    /*
     * @author MartinYang
     * @date 2025-10-25 02:48
     * @params:
     * @returns: void
     * 加上@Test 表示这个下面是一个测试方法
     * 如果注掉就需要使用main方法进行调用
     * @Test 这个是一个测试方法，可以直接运行
     */
    @Test
    void selectAll() {
        System.out.println(userInfoMapper.selectAll());
    }
    @Test
    void selectAll2() {
        System.out.println(userInfoMapper.selectAll());
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @Test
    void selectAllById() {
        System.out.println(userInfoMapper.selectAllById());
    }

    @Test
    void selectAllById2() {
        System.out.println(userInfoMapper.selectAllById2(3));
    }

    @Test
    void selectAllById3() {
        System.out.println(userInfoMapper.selectAllById3(3));
    }

    @Test
    void selectByNameAndPassword() {
        userInfoMapper.selectByNameAndPassword("zhangsan", "zhangsan").stream().
                forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user5");
        userInfo.setPassword("123456");
        userInfo.setAge(12);
        Integer result = userInfoMapper.insertUser(userInfo);
        System.out.println("影响行数："+ result + "   id:" + userInfo.getId() );
    }

    @Test
    void selectAllById4() {
        System.out.println(userInfoMapper.selectAllById4(3));
    }

    @Test
    void selectByNameAndPassword2() {
        userInfoMapper.selectByNameAndPassword2("zhangsan", "zhangsan").stream().
                forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user5");
        userInfo.setPassword("123456");
        userInfo.setAge(12);
        Integer result = userInfoMapper.insertUser2(userInfo);
        System.out.println("影响行数："+ result + "   id:" + userInfo.getId() );
    }

    @Test
    void deleteUser() {
        System.out.println(userInfoMapper.deleteUser(11));
    }

    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);
        userInfo.setPhone("1008611999");
        userInfo.setId(10);
        Integer result = userInfoMapper.updateUser(userInfo);
        System.out.println(result);
    }


    @Test
    void updateUserNameAge() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("liuqiaomang");
        userInfo.setAge(19);
        userInfo.setId(15);
        userInfoMapper.updateUserNameAge(userInfo);
    }

    @Test
    void testDeleteUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user4");
        userInfoMapper.deleteUser1(userInfo);
    }

    @Test
    void updateUserPassword() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("2082737266");
        userInfo.setUsername("杨木霖");
        userInfoMapper.updateUserPassword(userInfo);
    }

    @Test
    void selectAllById5() {
        System.out.println(userInfoMapper.selectAllById5(1));
    }

    @Test
    void selectByNameAndPassword3() {
        System.out.println(userInfoMapper.selectByNameAndPassword3("admin", "admin"));
    }


    @Test
    void selectUserInfoByOrder() {
        System.out.println(userInfoMapper.selectUserInfoByOrder("asc"));
    }

    @Test
    void selectUserInfoByLike() {
        System.out.println(userInfoMapper.selectUserInfoByLike("user"));
    }

    @Test
    void selectUserInfoByLike2() {
        System.out.println(userInfoMapper.selectUserInfoByLike2("user"));
    }


    @Test
    void insertUser3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("yml");
        userInfo.setPassword("123456");
        userInfo.setAge(12);
        Integer result = userInfoMapper.insertUser3(userInfo);
        System.out.println("影响行数："+ result + "   id:" + userInfo.getId() );

    }
}