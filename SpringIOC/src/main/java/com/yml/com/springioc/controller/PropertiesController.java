package com.yml.com.springioc.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-19
 * Time: 18:23
 */
@RequestMapping("/prop")
@ResponseBody
@Controller
public class PropertiesController {

    @Value("${my.key}")
    private  String myKey;


    @RequestMapping("/read")
    public String readValue(){
        return "读取配置文件my.key" + myKey;
    }



    @Value("${my.key2}")
    private  Boolean myKey2;

    /*
     * @author MartinYang
     * @date 2025-10-19 18:36
     * @params:@PostConstruct这个注解是一个初始化方法
     * @returns: void
     */
    @PostConstruct
    public  void init(){
        System.out.println("myKey:" + myKey);
        System.out.println("myKey2:"+myKey2);
    }


}
