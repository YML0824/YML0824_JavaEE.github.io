package com.yml.com.springioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:16
 */
public class Tire {

    private int size;
    private String color;

    public Tire(Integer size ,String color ) {
        this.size = size;
        this.color = color;
        System.out.println("tire init......,size=" + this.size);
    }
}
