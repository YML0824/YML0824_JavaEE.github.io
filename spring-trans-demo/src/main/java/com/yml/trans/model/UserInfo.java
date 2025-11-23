package com.yml.trans.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:04
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
