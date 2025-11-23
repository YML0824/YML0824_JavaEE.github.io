package com.yml.springblog.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-20
 * Time: 17:41
 */
@Data
public class UserLoginRequest {
    @NotNull(message = "用户名不能为空")
    @Length(max = 32,min = 2)
    private String userName;
    @NotNull(message = "密码不能为空")
    @Length(max = 32,min = 5 ,message = "密码长度不能小于5")
    private String password;
}
