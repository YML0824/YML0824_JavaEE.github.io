package com.yml.mybaits.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-27
 * Time: 9:03
 */

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String username;
    private Integer age;
}
