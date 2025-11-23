package com.yml.com.springioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 20:29
 */
@Configuration
public class UserConfig {


    //已经定义过了不能重复定义，不能这样做
/*    @Bean
    public String name(){
        return "lisi05";
    }*/
    public void print(){
        System.out.println("do config");
    }
}
