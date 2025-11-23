package com.yml.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-14
 * Time: 1:45
 */

@Slf4j
@Aspect
@Component
public class MyAspectDemo {
    //用自定义的注解
    //@Around("@annotation(com.yml.aop.aspect.MyAspect)")
    //也可以用现成的注解，比如@RequestMapping,可以使用Spring定义的注解，我们可以加一些东西
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
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
}
