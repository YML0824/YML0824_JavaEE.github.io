package com.bite.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * @author MartinYang
 * @date 2025-10-11 11:47
 * @params:
 * @returns:
 * SpringBoot 默认的扫描路径为启动类，启动类所在的路径
 * 及其子路径
 */
@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
