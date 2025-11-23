package com.yml.com.book.config;

import com.yml.com.book.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-07
 * Time: 1:05
 * 将拦截器注册到程序中
 * 写一个类实现WebMvcConfigurer接口
 *
 *
 */


@Configuration
public class WebConfig implements WebMvcConfigurer {
    //注入自定义的拦截器对象
    @Autowired
    private LoginInterceptor loginInterceptor ;

    /*
     * @author MartinYang
     * @date 2025-11-09 01:56
     * @params:
     * @returns: void
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/book/**");
    }
}
