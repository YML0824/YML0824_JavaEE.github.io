package com.yml.springblog.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 15:10
 * LocalDate这个包含了本地时区
 */
@Data
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String githubUrl;
    private Integer deleteFlag;
    private LocalDate createTime;
    private LocalDate updateTime;
}
