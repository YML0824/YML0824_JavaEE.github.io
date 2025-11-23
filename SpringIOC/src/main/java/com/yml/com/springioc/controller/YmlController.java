package com.yml.com.springioc.controller;

import com.yml.com.springioc.model.DbTypes;
import com.yml.com.springioc.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-20
 * Time: 9:02
 */

@Controller
public class YmlController {
    @Value("${my.key3}")
    private String mykey3;

    @Value("${my.key4}")
    private Integer mykey4;

    @Value("${person.id}")
    private Integer id;

/*    @Value("${dbtypes.ball}")
    private Map<String,String> ball;
    集合和Map都不能这样子用，只能放在对象中使用
    */


    @Autowired
    private Person person;


    @Autowired
    private DbTypes dbtypes;



    /*
     * @author MartinYang
     * @date 2025-10-20 09:11
     * @params:@PostConstruct这个注解是一个  初始化方法
     * @returns:
     */
    @PostConstruct
    public void init(){
        System.out.println("id = " + id);
        System.out.println("mykey3="+mykey3);
        System.out.println("mykey4="+mykey4);
        System.out.println("person="+person);
        System.out.println("dbtypes="+dbtypes);
        //System.out.println("ball="+ball);
    }



}
