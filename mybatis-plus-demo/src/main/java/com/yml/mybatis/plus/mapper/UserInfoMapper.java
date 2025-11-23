package com.yml.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yml.mybatis.plus.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-04
 * Time: 2:56
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from user_info where id = #{id}")
    UserInfo selectByIdMy(Integer id);


    UserInfo selectByIdMyTwo(Integer id);

    @Select("select id,username,password,age from user_info ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoByCondition(@Param(Constants.WRAPPER) Wrapper<UserInfo> queryWrapper);


    @Update("update user_info set age = age + #{addAge}  ${ew.customSqlSegment}")
    Integer updateById2(Integer addAge,@Param(Constants.WRAPPER) Wrapper<UserInfo> queryWrapper);
}
