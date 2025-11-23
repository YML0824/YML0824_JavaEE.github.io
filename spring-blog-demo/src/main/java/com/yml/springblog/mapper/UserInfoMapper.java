package com.yml.springblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yml.springblog.pojo.dataobject.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:18
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
