package com.yml.com.springioc;

import com.yml.com.springioc.component.StudentComponent;
import com.yml.com.springioc.component.UserComponent;
import com.yml.com.springioc.config.UserConfig;
import com.yml.com.springioc.controller.HController;
import com.yml.com.springioc.controller.HelloController;
import com.yml.com.springioc.model.Student;
import com.yml.com.springioc.rep.UserRepository;
import com.yml.com.springioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan可以定义一个扫描的路径，可以增加它扫描的路径,但是一般不用
//但是如果加了这个@ComponentScan("com.yml.com")，就默认以这个为准了,不加就是默认启动类的在的路径进行扫
//@ComponentScan("com.yml.com.springioc.config")
//一般会把启动类加在最外层，不用上面那个注解
@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        ApplicationContext  context = SpringApplication.run(SpringIocApplication.class, args);

/*
        //适合该类型对象只有一个,如果有多个就会出错
        HelloController bean = context.getBean(HelloController.class);
        bean.print();

        //
        HelloController bean2 = (HelloController) context.getBean("helloController");
        bean2.print();

        //名称和类型都要匹配得上才能进行映射
        HelloController bean3 = context.getBean("helloController", HelloController.class);
        bean3.print();

        System.out.println(bean);
        System.out.println(bean2);
        System.out.println(bean3);
*/
/*
        HelloController bean1 = (HelloController) context.getBean("helloController");
        bean1.print();

        HController bean5 = (HController) context.getBean("aaa");
        bean5.print();

        UserService bean = context.getBean(UserService.class);
        bean.print();

        UserRepository bean2 = context.getBean(UserRepository.class);
        bean2.print();

        UserComponent bean3 = context.getBean(UserComponent.class);
        bean3.print();

        UserConfig bean4 = context.getBean(UserConfig.class);
        bean4.print();
*/


/*
        //@Bean
        Student bean = (Student) context.getBean("s3");
        System.out.println(bean);

        Student bean2 = (Student) context.getBean("s2");
        System.out.println(bean2);

*/



        /*
         * @author MartinYang
         * @date 2025-10-18 23:07
         * @params:DI测试
         * @returns: void
         */

/*
        HelloController bean = context.getBean(HelloController.class);
        bean.print();



*/

/*

        UserService bean = context.getBean(UserService.class);
        bean.print();
*/

    }

}
