package com.yml.aop.controller;

import com.yml.aop.aspect.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-12
 * Time: 18:52
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("/t1")
    public Integer t1(){
        log.info("执行t1");
        return 1;
    }
    @MyAspect
    @RequestMapping("/t2")
    public Boolean t2(){
        log.info("执行t2");
        return true;
    }
    @RequestMapping("/t3")
    public String t3(){
        log.info("执行t3");
        return "t3";
    }
}
