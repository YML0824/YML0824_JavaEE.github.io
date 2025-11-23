package com.yml.mybaits.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-24
 * Time: 19:07
 */
@Data
public class UserInfo {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
