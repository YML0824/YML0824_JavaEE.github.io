package com.yml.trans.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:10
 */
@Mapper
public interface LogInfoMapper {
    @Insert("insert into  log_info(user_name,op) values (#{username},#{op})")
    Integer insertLog(String username,String op);
}
