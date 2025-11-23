package com.yml.aop.controller;

import com.yml.aop.aspect.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:     AOP作用的方法只能是public方法
 * User: YY_ang
 * Date: 2025-11-12
 * Time: 18:52
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/u1")
    public String u1(){
        log.info("执行u1");
        return "u1";
    }
    @MyAspect
    @RequestMapping("/u2")
    public String u2(){
        log.info("执行u1");
        return "u2";
    }
}
