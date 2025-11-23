package com.yml.mybaits.mapper;

import com.yml.mybaits.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-26
 * Time: 16:23
 */
@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> selectAll();

    List<UserInfo> selectAll2();

    Integer insertUser(UserInfo userInfo);

    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    Integer updateUser1(UserInfo userInfo);

    Integer updateUser2( String password, Integer age, Integer id);

    Integer deleteUser(Integer id);

    Integer deleteByNameAge(UserInfo userInfo) ;




    //动态SQL
    Integer insertUser3(UserInfo userInfo);

    List<UserInfo> selectByCondition(UserInfo userInfo);

    Integer updateByCondition(UserInfo userInfo);

    //批量删除
    Integer batchDelete(List<Integer> ids);

}
