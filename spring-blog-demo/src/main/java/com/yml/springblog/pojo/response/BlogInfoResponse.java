package com.yml.springblog.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yml.springblog.common.util.DateUtils;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 23:30
 */
@Data
public class BlogInfoResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;

    @JsonFormat(pattern = "yyy-MM-dd")
    private Date createTime;

//    //对返回结果进行简单的处理，需要重写get方法
//    public String getContent() {
//        return content==null?"":content.substring(0,50);
//    }
//    public String getCreateTime() {
//        return DateUtils.dateFormat(createTime);
//    }

}
