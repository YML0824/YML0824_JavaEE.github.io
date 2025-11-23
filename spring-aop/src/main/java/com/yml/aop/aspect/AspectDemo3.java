package com.yml.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-12
 * Time: 19:00
 */
@Order(2)
@Slf4j
@Aspect
//@Component
public class AspectDemo3 {

    @Before("execution(* com.yml.aop.controller.*.*(..))")
    public void  doBefore(){
        log.info("AspectDemo3 doBefore...");
    }

    @After("execution(* com.yml.aop.controller.*.*(..))")
    public void  doAfter(){
        log.info("AspectDemo3 doAfter...");
    }

}
