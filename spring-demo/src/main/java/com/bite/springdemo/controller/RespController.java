package com.bite.springdemo.controller;

import com.bite.springdemo.model.UserInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-11
 * Time: 10:41
 * @RestController = @ResponseBody + @Controller
 * @RestController只能放在类上，不能放在方法上
 * @Controller路径下的@Target({ElementType.TYPE})说明@Controller只能放在类上
 * @Target决定了注解可以放在什么位置
 * @ResponseBody表示返回数据
 * @Controller表示返回页面
 *
 *
 * 一个类中，既有返回页面的方法，又有返回数据的方法使用@Controller ,
 * 在返回数据方法上加@ResponseBody
 *
 * 如果一个类全部返回数据：可以使用@RestController 或者 @Controller + @ResponseBody
 * 如果一个类全部返回页面使用@Controller
 *
 * @ResponseBody 既是类注解，又是方法注解作为类注解的时候，表示该类的所有方法全部返回数据
 * 作为方法注解时，表示该方法返回数据
 */
@RequestMapping("/resp")
//@RestController  代表是打一个标签，告诉springboot要帮我们扫码这个路径的项目
@Controller
public class RespController {
    /*
     * @author MartinYang
     * @date 2025-10-11 12:53
     * @params:
     * @returns: java.lang.String
     * 返回页面
     */
    @RequestMapping("/r1")
    public String returnPage(){
        return "/aaa/index.html";//前端对应的路径是从static开始
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 12:53
     * @params:
     * @returns: java.lang.String
     * 返回数据
     * @ResponseBody加上这个表示该方法返回的是数据
     */
    @ResponseBody
    @RequestMapping("/r2")
    public String returnDate(){
        return "我是前端需要的数据";
    }

    /*
     * @author MartinYang
     * @date 2025-10-11 13:55
     * @params:
     * @returns: java.lang.String
     * 这里自动返回的是HTML
     */
    @ResponseBody
    @RequestMapping("/r3")
    public String returnHTML(){
        return "<h1>我是一级标题<h1/>";
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 22:03
     * @params:
     * @returns: java.lang.String
     * 返回文本
     */
    @ResponseBody
    @RequestMapping(value = "/r4",produces = "text/plain")
    public String returnTest(){
        return "<h1>我是一级标题<h1/>";
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 22:24
     * @params:
     * @returns: com.bite.springdemo.model.UserInfo
     * 返回JSON
     * 返回List，Map，以及其他格式的对象Spring，返回的都是JSON
     */
    @ResponseBody
    @RequestMapping("/r5")
    public UserInfo returnJSON(){
        UserInfo user = new UserInfo("zhangsan",1,1);
        return user;
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 22:27
     * @params:
     * @returns: com.bite.springdemo.model.UserInfo
     * 设置状态码
     * 状态码不影响页面的展示
     */
    @ResponseBody
    @RequestMapping("/r6")
    public UserInfo setStatus(HttpServletResponse response){
        response.setStatus(404);
        UserInfo user = new UserInfo("zhangsan",1,1);
        return user;
    }


    @ResponseBody
    @RequestMapping("/r7")
    public String setHeader(HttpServletResponse response){
        response.setHeader("myheader","myvalue");
        return "设置header成功";
    }





}
