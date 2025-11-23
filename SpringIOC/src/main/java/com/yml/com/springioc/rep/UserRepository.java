package com.yml.com.springioc.rep;

import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 20:13
 */
@Repository
public class UserRepository {
    public void print(){
        System.out.println("do Repository");
    }
}
