package com.bite.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-07-29
 * Time: 21:49
 */
//@RequestMapping不仅仅可以加在方法上也可以加在类上
@RequestMapping("/hello")
@RestController
public class HelloController {

    //@RequestMapping路径的映射
    //通过RequestMaping建立连接的
    @RequestMapping("/hello")
    public String sayHello(){

        String sayHello = "Hello SpringBoot";

        return sayHello;
    }
}
