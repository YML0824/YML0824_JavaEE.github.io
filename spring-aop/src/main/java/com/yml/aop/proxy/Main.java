package com.yml.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-14
 * Time: 14:29
 */
public class Main {
    public static void main(String[] args) {
        HouseSubject target = new RealHouseSubject();
//        HouseSubject houseSubject = new HouseProxy(target);
//        //houseSubject.saleHouse();
//        houseSubject.rentHouse();

        //JDK动态代理
        //动态的创建一个代理类
//        HouseSubject houseProxy =(HouseSubject) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                new Class[]{HouseSubject.class},
//                new JDKInvocation(target));
//        houseProxy.saleHouse();
//        houseProxy.rentHouse();


        //Cglib动态代理
        HouseSubject houseProxy =(HouseSubject) Enhancer.create(target.getClass(),new CGlibMethodInterceptor(target));
        houseProxy.rentHouse();

    }
}
