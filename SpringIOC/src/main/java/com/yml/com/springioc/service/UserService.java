package com.yml.com.springioc.service;

import com.yml.com.springioc.model.Student;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 19:56
 * @Service 加上这个注解，这个对象也交给Spring进行管理
 */

@Service
public class UserService {

    /*
     * @author MartinYang
     * @date 2025-10-19 06:35
     * @params:@Autowired 是根据类型来的，从容器中查找就会存在同一类型的多个对象的情况
     * @returns:
     */
/*    @Qualifier("s3")
    @Autowired
    private Student student;*/



    @Resource(name = "s2")
    private  Student student;

    public  void print(){
        System.out.println("do Service");
        System.out.println(student);
    }
}
