package com.yml.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:JDK实现的动态代理
 * User: YY_ang
 * Date: 2025-11-15
 * Time: 16:49
 */
public class JDKInvocation implements InvocationHandler {
    //目标对象，被代理的对象
    private Object target;

    public JDKInvocation(Object target) {
        this.target = target;
    }
    //执行目标方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我开始代理.......");
        Object result = method.invoke(target, args);
        System.out.println("我结束代理.......");
        return result;
    }
}
