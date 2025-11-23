package com.yml.com.springioc.v1;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:15
 */
public class Bottom {
    private Tire tire;

    public Bottom(Integer size,String color) {
        this.tire = new Tire(size ,color);
        System.out.println("bottom init......");
    }
}
