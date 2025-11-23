package com.yml.com.book.interceptor;

import com.yml.com.book.constant.Constants;
import com.yml.com.book.model.Result;
import com.yml.com.book.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:拦截器
 * 拦截器是Spring框架提供的核心功能之一，主要用来拦截用户的请求，在指定方法前后，根据
 * 业务需要执行预定的代码
 * 拦截器的使用步骤分为两步：
 * 1.定义拦截器
 * 2.注册配置拦截器
 * User: YY_ang
 * Date: 2025-11-07
 * Time: 0:50
 * 自定义拦截器，实现HandlerInterceptor，并重写其所有方法
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /*
     * @author MartinYang
     * @date 2025-11-11 14:39
     * @params:
     * @returns: boolean
     * preHandle()方法：目标方法执行前， 返回true：继续执行后续操作；返回false：中断后续操作
     * postHandle()方法：目标方法执行后执行
     * afterCompletion()方法：视图渲染完毕后执行，最后执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle目标方法执行前");
        //true 表示放行 false表示拦截
        HttpSession session = request.getSession(false);
        if(! checkUser(session)){
            response.setContentType("text/html;charset=utf-8");

            response.setStatus(401);

            String msg = "用户未登录";
            response.getOutputStream().write(msg.getBytes("utf-8"));
            return false;
        }

        return true;
    }
    //如果preHandle不放行，下面的代码执行不到

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle目标方法执行完成后");
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion试图渲染完成");
    }

    public boolean checkUser(HttpSession session) {
        if(session == null||session.getAttribute(Constants.SESSION_USER_KEY) == null){
            log.warn("用户未登录");
            //用户未登录
            return false;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo==null || userInfo.getId() <= 0){
            log.warn("用户未登录");
            return  false;
        }
        log.info("用户已登录");
        return true;
    }
}
