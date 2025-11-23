package com.yml.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yml.mybatis.plus.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-04
 * Time: 3:02
 */
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("123456");
        userInfo.setAge(15);
        userInfo.setPhone("1008611");
        userInfoMapper.insert(userInfo);

    }

    @Test
    void delete(){
        userInfoMapper.deleteById(35);
    }

    @Test
    void update(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(20);
        userInfo.setUsername("admin");
        userInfo.setPassword("123456");
        userInfo.setAge(15);
        userInfo.setPhone("1008611");
        userInfoMapper.updateById(userInfo);
    }

    @Test
    void selectById(){
        UserInfo userInfo = userInfoMapper.selectById(20);
        System.out.println(userInfo);
    }




    /*
     * @author MartinYang
     * @date 2025-11-05 23:38
     * @params:select id,username,password,age delete_flag from user_info where age = 10 and username like "%min%"
     * @returns: void
     */
    @Test
    void selectByCondition(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,username,password,age,delete_flag")
                .eq("age",15)
                .like("username","min");
        System.out.println(userInfoMapper.selectList(queryWrapper));
    }

    @Test
    void selectByCondition2(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(UserInfo::getId,UserInfo::getUsername,UserInfo::getPassword,
                UserInfo::getAge,UserInfo::getDeleteFlag)
                .eq(UserInfo::getAge,15)
                .like(UserInfo::getUsername,"min");
        System.out.println(userInfoMapper.selectList(queryWrapper));
    }


    /*
     * @author MartinYang
     * @date 2025-11-06 09:07
     * @params: select id,username,password,age delete_flag from user_info where age = 10 and username like "%min%"
     * @returns: void
     */
    @Test
    void selectByCondition3(){
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(UserInfo::getId,UserInfo::getUsername,UserInfo::getPassword,
                UserInfo::getAge,UserInfo::getDeleteFlag)
                .eq(UserInfo::getAge,15)
                .like(UserInfo::getUsername,"min");
        userInfoMapper.selectList(lambdaQueryWrapper);

    }


    /*
     * @author MartinYang
     * @date 2025-11-06 00:05
     * @params:update user_info set delete_flag =? where age <= 20
     * @returns: void
     */
    @Test
    void updateByCondition(){
        UserInfo userInfo = new UserInfo();
        userInfo.setDeleteFlag(1);

        //where age <= 20
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",15);

        userInfoMapper.update(userInfo,queryWrapper);
    }

    @Test
    void updateByCondition2(){

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete_flag",1)
                .lt("age",15);
        userInfoMapper.update(updateWrapper);


    }

    /*
     * @author MartinYang
     * @date 2025-11-06 01:20
     * @params:update user_info set delete_flag = 0, age = 5 where id in(1,2,3);
     * @returns: void
     */
    @Test
    void updateByCondition3(){
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("delete_flag",0).set("age",18)
                .in("id", List.of(1,2,3));
        userInfoMapper.update(updateWrapper);
    }

    /*
     * @author MartinYang
     * @date 2025-11-06 01:32
     * @params:update user_info set age = age + 10 where id in(1,2,3)
     * @returns: void
     */
    @Test
    void updateByCondition4(){
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("age = age + 10")
                .in("id", List.of(1,2,3));
        userInfoMapper.update(updateWrapper);
    }


    @Test
    void updateByCondition5(){

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(UserInfo::getDeleteFlag,0).lt(UserInfo::getAge,15);
        userInfoMapper.update(updateWrapper);


    }


    //delete from user_info where age = 10;
    @Test
    void deleteByCondition(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",19);
        userInfoMapper.delete(queryWrapper);
    }


    @Test
    void selectByIdMy() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        System.out.println(userInfoMapper.selectByIdMy(1));

    }

    @Test
    void selectByIdMyTwo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        System.out.println(userInfoMapper.selectByIdMyTwo(1));
    }

    /*
     * @author MartinYang
     * @date 2025-11-06 09:28
     * @params:
     * @returns:
     * select * from user where age >= 18
     *
     */
    @Test
    void selectByIdMyThree() {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ge(UserInfo::getAge,15);
        List<UserInfo> userInfos = userInfoMapper.selectList(lambdaQueryWrapper);
        System.out.println(userInfos);

    }

    /*
     * @author MartinYang
     * @date 2025-11-06 09:35
     * @params:
     * @returns: void
     * select * from user where age < 18
     */
    @Test
    void selectByIdMyFour() {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(UserInfo::getAge ,18);
        List<UserInfo> userInfos = userInfoMapper.selectList(lambdaQueryWrapper);
        System.out.println(userInfos);

    }

    @Test
    void selectUserInfoByCondition() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",15);
        userInfoMapper.selectUserInfoByCondition(queryWrapper).forEach(System.out::println);
    }


    @Test
    void updateById2() {
        //where id in(1,2,3)
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(UserInfo::getId,List.of(1,2,3));
        userInfoMapper.updateById2(12,lambdaQueryWrapper);
    }
}