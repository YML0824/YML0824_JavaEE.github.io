package com.yml.com.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-12
 * Time: 17:00
 */

@Slf4j
@Aspect
@Component
public class TimeAspect {

    /*
     * @author MartinYang
     * @date 2025-11-12 18:02
     * @params:
     * @returns: java.lang.Object
     *  记录Controller下的方法消耗时间
     * @Around这个是通知的类型，就是具体类型执行的时机
     * execution(* com.yml.com.book.controller.*.*(..)) 定义了一个规则，
     * 这个规则包含了对哪些方法生效  --》切点表达式  属于真实的执行方法
     *
     */
    @Around("execution(* com.yml.com.book.controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        //1.记录开始时间
        long start = System.currentTimeMillis();
        //2.执行目标方法
        Object proceed = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info(pjp.getSignature().toString() + "耗时：" + (end - start) + "ms");
        return proceed;
    }
}
