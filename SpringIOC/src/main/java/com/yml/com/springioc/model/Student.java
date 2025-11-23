package com.yml.com.springioc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-18
 * Time: 18:16
 *
 * 加上@Component 就是把这个对象交给Spring进行管理了
 */

//@Component
@AllArgsConstructor   //生成一个全参的构造函数
@NoArgsConstructor    //生成一个无参的构造函数
@Data
public class Student {

    private String name;
    private Integer age;
}
