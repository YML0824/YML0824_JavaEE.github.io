package com.bite.springdemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-12
 * Time: 18:17
 */
@RequestMapping("/user")
@RestController
public class UserController {

    /*
     * @author MartinYang
     * @date 2025-10-12 19:06
     * @params:
     * @returns: java.lang.Boolean
     * equals会报空指针异常NullpointException
     * "admin".equals(userName) 当"admin"这个值为null的时候会报空指针异常
     * userName这里为null不会报
     * 所以通常把常量写在前面
     * HttpSession session 这里是创建session的
     */
    //建议这样写
    @RequestMapping("login")
    public  Boolean login(String userName, String password ,HttpSession session){
        //参数校验,账号密码不能为空，也不能为null
/*        if(userName == null || password == null || userName == "" || password == ""){
            return false;
        }*/
        //StringUtils是Spring的一个工具类
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //校验用户名和密码身份正确
        //还是未学习数据库相关操作，暂且把账号和密码写死 admin admin
        //一般把常量写在前面
        if("admin".equals(userName) && "123456".equals(password)){
            //密码正确
            session.setAttribute("userName",userName);
            //session.setAttribute("password",password);
            return true;
        }

        return false;


    }


    //不建议这样写
    public  Boolean login2(String userName,String password){
        if(StringUtils.hasLength(userName) && StringUtils.hasLength(password)){//如果有值，就进入判断
            if("admin".equals(userName) && "123456".equals(password)){
                return true;
            }
        }
        return false;
    }


    @RequestMapping("/getLoginUser")
    public String getLoginUserName(HttpSession session){
        String userName =(String)session.getAttribute("userName");
        return userName;
    }



}
