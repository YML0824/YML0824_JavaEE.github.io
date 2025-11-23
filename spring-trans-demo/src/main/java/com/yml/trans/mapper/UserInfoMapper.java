package com.yml.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:09
 */
@Mapper
public interface UserInfoMapper {
    @Insert("insert into user_info(user_name,password)values (#{name},#{password})")
    Integer insert(String name,String password);
}
