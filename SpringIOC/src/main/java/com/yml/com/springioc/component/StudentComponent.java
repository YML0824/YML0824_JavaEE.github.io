package com.yml.com.springioc.component;

import com.yml.com.springioc.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-18
 * Time: 18:23
 * 加上@Component 表示把StudentComponent交给 Spring进行管理
 */

@Component
public class StudentComponent {

    //@Bean(name = {"s3","s4"}) 一样的，name和Value都可以省略
    //@Bean(value = {"s3","s4"})
    //@Primary
    @Bean({"s3","s4"})
    public Student s1(){
        return new Student("张三",11);
    }



    @Bean
    public String name1(){
        return "lisi";
    }

    @Bean
    public String name2(){
        return "lisi2";
    }


    /*
     * @author MartinYang
     * @date 2025-10-18 19:53
     * @params:Spring 会从Spring容器当中，查找String类型的对象，赋值给name
     * @returns: com.yml.com.springioc.model.Student
     */
    //@Primary
    @Bean
    public Student s2(@Qualifier("name1") String name){
        return new Student(name,12);
    }
}
