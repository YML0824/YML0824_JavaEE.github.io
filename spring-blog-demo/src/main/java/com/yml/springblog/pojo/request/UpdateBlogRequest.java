package com.yml.springblog.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-22
 * Time: 18:27
 */
@Data
public class UpdateBlogRequest {
    @NotNull(message = "id不能为null")
    private Integer id;
    private String title;
    private String content;
}
