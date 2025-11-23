package com.yml.springblog.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-20
 * Time: 17:37
 */
@AllArgsConstructor
@Data
public class UserLoginResponse {
    private String token;
    private Integer userId;
}
