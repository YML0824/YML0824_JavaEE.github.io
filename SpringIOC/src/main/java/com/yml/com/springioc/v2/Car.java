package com.yml.com.springioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:13
 */
public class Car {

    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
        System.out.println("car init......");
    }

    public void run() {
        System.out.println("car run...");
    }
}
