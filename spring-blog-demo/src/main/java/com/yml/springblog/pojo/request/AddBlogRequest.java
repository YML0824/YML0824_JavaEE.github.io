package com.yml.springblog.pojo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-22
 * Time: 15:52
 */
@Data
public class AddBlogRequest {
    @NotNull(message = "userId不能为null")
    private Integer userId;
    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "内容不能为空")
    private String content;

}
