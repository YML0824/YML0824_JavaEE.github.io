package com.yml.mybaits.mapper;

import com.yml.mybaits.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-27
 * Time: 9:07
 */
@Mapper
public interface ArticleInfoMapper {
    ArticleInfo selectArticleInfoById(Integer id);
}
