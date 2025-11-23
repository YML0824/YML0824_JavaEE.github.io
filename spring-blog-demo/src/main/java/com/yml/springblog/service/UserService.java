package com.yml.springblog.service;

import com.yml.springblog.pojo.request.UserLoginRequest;
import com.yml.springblog.pojo.response.UserInfoResponse;
import com.yml.springblog.pojo.response.UserLoginResponse;
import jakarta.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:40
 */
public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(@NotNull(message = "userId不能为空") Integer userId);

    UserInfoResponse getAuthorInfo(@NotNull(message = "blogId不能为空") Integer blogId);
}
