package com.yml.com.springioc.v1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:14
 */
public class Framework {
    private Bottom bottom;

    public Framework(Integer size ,String color) {
        this.bottom = new Bottom(size ,color);//底盘初始化完成
        System.out.println("framework init......");
    }
}
