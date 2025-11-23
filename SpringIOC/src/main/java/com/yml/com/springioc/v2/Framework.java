package com.yml.com.springioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:14
 */
public class Framework {
    private Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom =bottom;
        System.out.println("framework init......");
    }
}
