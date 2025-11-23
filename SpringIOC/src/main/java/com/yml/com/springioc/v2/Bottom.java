package com.yml.com.springioc.v2;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:15
 */
public class Bottom {
    private Tire tire;

    public Bottom(Tire tire) {
        this.tire = tire;
        System.out.println("bottom init......");
    }
}
