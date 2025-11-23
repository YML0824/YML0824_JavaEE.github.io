package com.yml.aop.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-14
 * Time: 14:20
 */
public class HouseProxy implements HouseSubject {

    private HouseSubject houseSubject;

    public HouseProxy(HouseSubject houseSubject) {
        this.houseSubject = houseSubject;
    }

    @Override
    public void saleHouse() {
        System.out.println("我是中介，我帮房东开始代理");
        //真正的交易
        houseSubject.saleHouse();
        System.out.println("我是中介，我帮房东结束代理");
    }

    @Override
    public void rentHouse() {
        System.out.println("我是中介，我帮房东开始代理");
        //真正的交易
        houseSubject.rentHouse();
        System.out.println("我是中介，我帮房东结束代理");
    }
}
