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
 *
 * 存在多个切面类时，默认按照切面类的字母排序
 * @Before 通知：字母排名靠前的先执行
 * @After 通知：字母排名靠前的后执行
 * 但是这种方式不方便管理，我们的类名更多还是具备一定的含义的
 * Spring 给我们提供了一个新的注解，来控制这些切面通知的执行顺序：@Order
 * @Order注解的标识的切面类，得出结论：
 * @Before通知：数字越小先执行
 * @Aftert通知：数字越大先执行
 * @Order控制切面的优先级，先执行优先级较高的切面，再执行优先级较低的切面，最终执行目标方法
 */
@Order(1)
@Slf4j
@Aspect
//@Component
public class AspectDemo4 {

    @Before("execution(* com.yml.aop.controller.*.*(..))")
    public void  doBefore(){
        log.info("AspectDemo4 doBefore...");
    }

    @After("execution(* com.yml.aop.controller.*.*(..))")
    public void  doAfter(){
        log.info("AspectDemo4 doAfter...");
    }

}
