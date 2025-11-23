package com.yml.com.springioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 21:37
 */

@ResponseBody
/*@Controller*/
@Service
public class UserController {
    @RequestMapping("/hello")
    public  String hello(){
        return "测试Controller和service的区别";
    }
}
