package com.yml.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-12
 * Time: 19:00
 */

//AspectDemo1是一个切面类
@Slf4j
@Aspect
//@Component
public class AspectDemo1 {

    //定义切点
    @Pointcut("execution(* com.yml.aop.controller.*.*(..))")
    public void pt(){
    };

    @Around("pt()")
    public Object timeRecord(ProceedingJoinPoint pjp)  {
        log.info("目标方法执行前.........");
        //执行目标方法
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            log.error("do Around throwing");
        }
        log.info("目标方法执行后.........");
        return proceed;
    }

    @Before("pt()")
    public void  doBefore(){
        log.info("doBefore...");
    }

    @After("pt()")
    public void  doAfter(){
        log.info("doAfter...");
    }

    @AfterReturning("pt()")
    public void  doAfterReturning(){
        log.info("doAfterReturning...");
    }

    //切面，上面这些都是
    @AfterThrowing("pt()")
    public void  doAfterThrowing(){
        log.info("doAfterThrowing...");
    }




}
