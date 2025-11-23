package com.yml.com.springioc.controller;

import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 16:51
 *
 * 通过@Controller 标志的类 得到的是一个对象，
 * @Controller("aaa") 可以加("aaa")修改名称，也可以不加
 */

@Controller("aaa")
public class HController {

    private String name;
    public void print(){
        System.out.println("do controller ");
    }
}
