package com.yml.com.book.mapper;

import com.yml.com.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 17:30
 */
@Mapper
public interface UserInfoMapper {

    @Select("select  * from user_info  where  user_name = #{userName}")
    UserInfo queryUserInfoByName(String userName);
}
