package com.yml.com.springioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-20
 * Time: 9:24
 * 从配置文件中读取一个对象
 * //@ConfigurationProperties   从配置文件中  读取属性,然后一个一个对应上
 * prefix = "person"这里代表是从person中读取，赋值给类的属性成为一个对象
 */


@ConfigurationProperties(prefix = "person")
@Configuration
@Data
public class Person {
    private  Integer id;
    private String name;
    private Integer age;
}
