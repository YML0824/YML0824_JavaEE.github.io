package com.yml.aop.proxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-15
 * Time: 17:25
 */
public class CGlibMethodInterceptor implements MethodInterceptor {
    //目标对象
    private Object target;

    public CGlibMethodInterceptor(Object target) {
        this.target = target;
    }

    //代理逻辑
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我开始代理");
        Object invoke = method.invoke(target, args);
        System.out.println("我结束代理");
        return invoke;
    }
}
