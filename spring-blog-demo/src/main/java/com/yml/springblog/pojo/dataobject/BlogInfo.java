package com.yml.springblog.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 15:11
 */
@Data
public class BlogInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private LocalDateTime updateTime;
}
