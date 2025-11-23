package com.yml.com.springioc.component;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 20:23
 */

@Component
public class UserComponent {
    public void print(){
        System.out.println("do Component");
    }
}
