package com.yml.aop.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-14
 * Time: 14:18
 */
public class RealHouseSubject implements HouseSubject {
    @Override
    public void saleHouse() {
        System.out.println("我是房东，我卖房");
    }

    @Override
    public void rentHouse() {
        System.out.println("我是房东，我出租房子");
    }
}
