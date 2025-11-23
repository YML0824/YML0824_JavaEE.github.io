package com.bite.springdemo.controller;

import com.bite.springdemo.model.MessageInfo;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-08-17
 * Time: 3:04
 * 建立连接部分
 */

/*@RequestMapping("/user")
* ("/user")是路径
* 可以修饰类，也可以修饰方法
*
* 资源路径：类路径+方法路径
* 资源路径唯一
* 建议：给所有的类都加上类路径
* 1.避免发生错误
* 2.提高可读性
*
*
* 在Spring MVC 中使用@RequestMapping来实现URL路由映射，也就是浏览器连接程序的作用
* @RequestMapping是Spring Web MVC 应用程序中最常用到的注解之一，它用来注册接口的路由映射
* 路由映射：当用户访问一个URL时，将用户的请求对应的程序中某个类的某个方法的过程就叫路由映射
* @RequestMapping既可以修饰类，也可以修饰方法，当修饰类和方法时，访问的地址是类路径+方法路径
* 1.@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
* 2.@Requestmapping标识一个方法：设置映射请求请求路径的具体信息
*
*@RequestMapping加在类上表示的是类路径，加在方法上就是方法路径
* 访问的时候是类路径+方法路径
*/
 //建立连接
//类路径
@RequestMapping("/user2")
//加上RestController告诉spring-boot帮我们扫描这个类
/*
 * @RequestController 起到的作用
 * 一个项目中，会有很多类，每个类可能有很多方法，Spring程序怎么知道要执行哪个方法？
 * Spring会对所有的类进行扫描，如果类加了注解@RestController,Spring才会去看这个类里面的方法
 * 有没有加@RequestMapping这个注解，当然它的作用还有很多
 *
 */
@RestController
public class UserController2 {

    //方法路径
    //@RequestMapping不仅支持get ,也支持post
    //@RequestMapping的URL路径最前面加不加/(斜杆)都是可以的，
    //Spring程序启动时，会进行判断，如果前面没有加/,Spring会拼上一个/
    @RequestMapping("/m1")
    public String m1(){
        return "m1";
    }




    //发起请求的方式可以是get也可以是post
    //通过浏览器发起的请求都是get请求
    //只支持get
    @RequestMapping(value = "/m2",method = RequestMethod.GET)
    public String m2(){
        return "m1";
    }
    /*
     * {
    "timestamp": "2025-10-08T19:35:56.607+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "path": "/user/m2"
     }
     * 如果是post请求会出现以上信息，方法不允许
     * 4开头的是客户端请求错误
     * 404路径不存在
     * 405方法不允许
     */


    //只支持post
    @RequestMapping(value = "/m3",method = RequestMethod.POST)
    public String m3(){
        return "m3";
    }


    //只支持get
    @GetMapping("/m4")
    public String m4(){
        return "m4";
    }


    //路径+请求方式唯一
    //只支持post
    @PostMapping("/m5")
    public String m5(){
        return "m5";
    }

    //支持多个
    @RequestMapping(value = "/m6",method = {RequestMethod.GET,RequestMethod.POST})
    public String m6(){
        return "m6";
    }
    /*
     * @author MartinYang
     * @date 2025-10-10 20:44
     * @params:
     * @returns:
     * @RequestMapping
     * 类注解：该类所有的方法都添加这个路径
     * 方法注解：该方法的路径
     * 访问的路径是：类路径+方法路径
     */


    public void testLombok(){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage("hello");
    }

}
