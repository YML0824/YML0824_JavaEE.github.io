package com.yml.springblog.common.interceptor;

import com.yml.springblog.common.constant.Constants;
import com.yml.springblog.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created with IntelliJ IDEA.
 * Description:拦截器定义
 * User: YY_ang
 * Date: 2025-11-21
 * Time: 1:18
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = request.getHeader(Constants.USER_TOKEN_HEADER_KEY);
        log.info("从header中获取Token:{}",userToken);
        if(userToken == null){
            //拦截
            //401用户未登录
            //403用户没权限
            response.setStatus(401);
            return false;
        }
        //校验Token是否合法
        Claims claims = JwtUtils.parseToken(userToken);
        if(claims==null){
            //拦截
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
