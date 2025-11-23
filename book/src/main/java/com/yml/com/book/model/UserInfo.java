package com.yml.com.book.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 16:38
 */

@Data
public class UserInfo {

    private Integer id;

    private String userName;

    private String password;

    private Integer deleteFlag;

    private Date createTime;

    private Date updateTime;
}
