package com.yml.mybaits.mapper;

import com.yml.mybaits.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-27
 * Time: 9:13
 */
@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void selectArticleInfoById() {
        System.out.println(articleInfoMapper.selectArticleInfoById(1));
    }
}