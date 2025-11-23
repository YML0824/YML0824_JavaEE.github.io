package com.yml.springblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yml.springblog.pojo.dataobject.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:21
 */
@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {
}
