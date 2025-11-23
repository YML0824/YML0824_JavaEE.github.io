package com.yml.com.springioc.controller;

import com.yml.com.springioc.config.UserConfig;
import com.yml.com.springioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-17
 * Time: 16:51
 *
 * 通过@Controller 标志的类 得到的是一个对象，
 */

@Controller
public class HelloController {

    /*
     * @author MartinYang
     * @date 2025-10-18 23:06
     * @params:属性注入
     * HelloController 有个依赖 是userService
     * 通过 @Autowired 注入 userService 这个依赖，@Autowired是从Spring容器中找到
     * UserService 这个类型的对象 ，并且赋值给这个属性
     * @returns:
     *
     * @Autowired 的作用就是从Spring 容器中，根据类型获取对象，并赋值
     * @Autowired 不能注入被final修饰的属性
     */
//    @Autowired
//    private UserService userService;
    





    
    /*
     * @author MartinYang
     * @date 2025-10-18 23:39
     * @params:构造方法完成属性注入
     * @returns:
     *
     *  @Autowired 在构造函数上面加这个就指定了默认的构造函数，如果不加默认是无参的构造函数
     *
     * 如果只有一个构造方法，@Autowired 可以省略
     * 如果存在多个构造方法 ， 默认的构造方法是无参的构造方法
     * 也可以通过@Autowired 来指定默认的构造方法
     */
/*    private UserConfig userConfig;
    private UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public HelloController(UserConfig userConfig, UserService userService) {
        this.userConfig = userConfig;
        this.userService = userService;
    }*/

    /*
     * @author MartinYang
     * @date 2025-10-19 03:35
     * @params:Spring创建对象是依靠  反射  创建的
     * @returns:
     */
    //当我们加了有参的构造函数，也要把无参的构造函数一起写上
/*    public HelloController() {
    }*/



    /*
     * @author MartinYang
     * @date 2025-10-19 03:58
     * @params:setter方法注入
     * @returns:
     */
    private UserService userService;

    private UserConfig userConfig;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    public void print(){
        System.out.println("do controller ");
        System.out.println(userService);
        //userService.print();
        userConfig.print();
    }
}
