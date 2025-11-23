package com.bite.springdemo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-12
 * Time: 23:50
 */
@Data
/*@Getter
@Setter*/
public class MessageInfo {
/*    @Getter
    @Setter*/
    private Integer id;
    private String from;//单独加在from上也可以
    private String to;
    private String message;
    private Integer deleteFlag ;
    private Date createTime;
    private Date updateTime;

}
