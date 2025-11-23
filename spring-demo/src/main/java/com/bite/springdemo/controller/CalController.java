package com.bite.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-12
 * Time: 17:07
 */
@RequestMapping("/calc")
//@RestController 表示返回数据  @Controller 表示返回视图
@RestController
public class CalController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2){
        if(num1 == null || num2 == null){
            return "参数不合法，请检查后再提交";
        }
        Integer result = num1 + num2;
        return "<h1>计算机计算结果：" + result + "<h1/>";
    }

}
