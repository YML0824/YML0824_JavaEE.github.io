package com.bite.springdemo.controller;

import com.bite.springdemo.model.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-08-17
 * Time: 21:05
 * 请求学习部分
 * 请求参数的传递
 *使用postman 发生请求和客户端发送请求，对于后端是一样的
 *
 *请求部分
 * 访问不同的路径，就是发生不同的请求，在发送请求时，可能会带一些参数，所以学习Spring的请求，
 * 主要是学习Spring的请求，主要是学习如何传递参数到后端如何接收
 *
 * 资源路径唯一不支持重载
 * 不管是传递对象还是传递普通参数，名称要与后端接收参数的名称一致
 */
@RequestMapping("/request")
@RestController
/*@ResponseBody
@Controller*/
//@RestController = @ResponseBody + @Controller
//@ResponseBody既是类注解，也是一个方法注解
public class RequestController {

    //接收单个参数，在SpringMVC中直接使用方法中的参数就可以
    //写路径的映射
    @RequestMapping("/r1")//这里不传的时候得到的是null,所有可以不传
    public String r1( String keyword){//接收参数，必须在方法上声明,和传递的参数的名称保持一样
        return "接收参数：" + keyword;
    }


    //传递多个参数和单个参数一样，直接使用方法的传参接收既可，使用多个形参
    @RequestMapping("/r2")//模仿实现登录传参
    public String r2( String userName,String password){
        return "接收参数：userName:" + userName + ", password :"+password;
    }


    @RequestMapping("/r3")
    public String r3( Integer number){
        return "接收参数:" + number;
    }


    @RequestMapping("/r4")
    public String r4( int number){//非包装类型不能赋值为null，必须给值
        return "接收参数:" + number;
    }


    //多个参数封装成对象
    //传递对象，使用对象接收，在postman上写的方法和传递多个参数一样
    @RequestMapping("/r5")
    public String r5(UserInfo userInfo){
        return "接收参数: userInfo = " + userInfo.toString();
    }


    /*
     * @author MartinYang
     * @date 2025-10-09 14:09
     * @params:
     * @returns: java.lang.String
     * 某些特殊情况下，前端传递的参数key和我们后端接收的key可以不一致，比如前端传递了一个time给后端
     * 而后端是使用createtime字段接收的，这样就会出现参数接收不到的情况，如果出现正在情况，我们就可以
     * 使用@RequestParam来重命名前后端的参数值
     *
     * 部分结论：
     * 1.使用@RequestParam进行参数重命名时，请求参数只能和@RequestParam声明的名称一致，
     * 才能进行参数赋值
     * 2.使用@RequestParam进行参数重名字时，参数就变成了必传参数
     *
     * 非必传参数设置
     * 如果我们的实际业务前端的参数是一个非必传的参数，针对上述问题如何解决
     * 先了解下参数必传的原因，我们查看@RequestParam注册细节就可以发现端倪：
     * @Target({ElementType.PARAMETER})
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        public @interface RequestParam {
        @AliasFor("name")
        String value() default "";

        @AliasFor("value")
        String name() default "";

        boolean required() default true;

        String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";
        }
        *
        * 可以看到required的值默认值为ture,表示含义就是：该注释修饰的参数默认为必传
        * 既然如此，我们通过设置@Requestparam 中 required = flase 来避免不传递时报错
     *
     */
    //从前端接收参数q，赋值给keyword
    //对参数重命名
    @RequestMapping("/r6")
    public String r6(@RequestParam(value = "q",required = false) String keyword){
        //如果不想设置为必传参数，就设置为false
        //从前端接收的是q,但是后端接收后赋值给keyword
        //@RequestParam(value = "q",required = false)的q是必传参数，因为加上了RequestParam
        //前面的可以不参也可以，但是这里写了RequestParam是属于必传参数
        return "接收参数: keyword = " + keyword;
    }

    //传递数组
    //Spring MVC可以自动绑定数组参数的赋值
    /*
     * @author MartinYang
     * @date 2025-10-09 14:30
     * @params:
     * @returns: java.lang.String
     * 使⽤浏览器发送请求并传参:
    数组参数：请求参数名与形参数组名称相同且请求参数为多个, 后端定义数组类型形参即可接收参数
    http://127.0.0.1:8080/param/m5?
    arrayParam=zhangsan&arrayParam=lisi&arrayParam=wangwu
    或者使⽤ http://127.0.0.1:8080/param/m6?listParam=zhangsan%2clisi%2cwangwu
    或者使⽤ http://127.0.0.1:8080/param/m5?arrayParam=zhangsan,lisi,wangwu
     */
    @RequestMapping("/r7")
    public String r7(String[] arr){//如果想接收一个数组，就是直接用数组接收
        return  "接收参数 arr = " + Arrays.toString(arr);
        //数组传参的两种方式：
        // 1.在postman里面传参多个重名的key可以组装成为一个数组
        // 2.在postman可以使用逗号进行分割(,) 比如key为arr Value为：1,33,44
    }

    /*
     * @author MartinYang
     * @date 2025-10-09 14:33
     * @params:
     * @returns: java.lang.String
     * 传递集合，需要加上@RequestParam
     * 集合在postman的传参方式和数组一样
     * 集合参数：和数组类似，同一个请求参数名有为多个，且需要使用@RequestParam绑定参数关系
     * 默认情况下，请求中参数名相同的多个值，是封装到数组，如果要封装到集合，要使用@RequestParam
     * 绑定参数关系
     *
     * 请求方式和数组类似
     * 浏览器传参:
    ⽅式⼀: http://127.0.0.1:8080/param/m6?listParam=zhangsan&listParam=lisi&listParam=wangwu
    ⽅式⼆: http://127.0.0.1:8080/param/m6?listParam=zhangsan%2clisi%2cwangwu
    %2c 是逗号的转义编码, 解码后的url为: http://127.0.0.1:8080/param/m6?
    listParam=zhangsan,lisi,wangwu
     */
    @RequestMapping("/r8")
    //把数组的参数绑定成一个list
    public String r8(@RequestParam List<Integer> list){//这里List要使用参数绑定
        return "接收参数： list = " + list;
    }

    /*
     * @author MartinYang
     * @date 2025-10-09 20:52
     * @params:
     * @returns: java.lang.String
     * @RequestParam 和 @RequestBody都是请求相关的
     * 传递JSON
     * @RequestBody请求正文
     */
    @RequestMapping("/r9")
    public  String r9(@RequestBody UserInfo userInfo){//接收一个Json对象
        System.out.println(userInfo.getName());
        System.out.println(userInfo.getAge());
        System.out.println(userInfo.getGender());
        return userInfo.toString();
    }

    //从URL中获取一个参数
    @RequestMapping("/article/{articleID}")
    public String r10(@PathVariable Integer articleID){
        return "获取文字ID:" + articleID;
    }

    //PathVariable是一个参数注解，每个参数都要加注解，这个是一个必传参数
    /*
     * @author MartinYang
     * @date 2025-10-10 16:05
     * @params:
     * @returns: java.lang.String
     * 从URL中获取参数
     * @PathVariable("type")可以将参数重命名
     * 可以重命名，参数必传
     */
    @RequestMapping("/article/{type}/{articleID}")
    public String r11(@PathVariable Integer articleID , @PathVariable("type") String articeleType){
        return "获取文字ID:" + articleID +", type:" + articeleType;
    }


    //上传文件
    /*
     * @author MartinYang
     * @date 2025-10-10 16:39
     * @params:
     * @returns: java.lang.String
     * 使用@RequestPart("file11")重对file11命名为file
     * 上传文件使用MultipartFile接收
     */
    @RequestMapping("/r12")
    public  String r12(@RequestPart("file11") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        //文件上传
        file.transferTo(new File("C:\\Users\\YY_ang\\Desktop\\C\\" + file.getOriginalFilename()));
        return "文件上传成功";
    }

    /*
     * @author MartinYang
     * @date 2025-10-10 17:12
     * @params:
     * @returns:
     * 路径参数：URL除去 查询字符串
     * 请求参数：URL的查询字符串和请求正文
     * http://XXX/1/  的 1/ 属于路径参数
     * http://XXX?page=1   ?后面都是属于请求参数
     * body里面也是请求参数
     * 请求参数除了键值对，还有可能是JSON
     *
     */

    /*
     * @author MartinYang
     * @date 2025-10-10 19:32
     * @params:
     * @returns:
     * cookie 是存储在客户端上的
     * Session 是存储在服务器上的
     * HTTP协议自身是属于“无状态”协议
     * “无状态”的含义指的是：默认情况下HTTP协议的客户端和服务器之间的这次通信
     * 和下次通信之间没有直接的联系
     * 无状态：可以理解为无记忆力
     */



    /*
     * @author MartinYang
     * @date 2025-10-10 21:39
     * @params:
     * @returns: java.lang.String
     * HttpServletRequest request 表示HTTP请求：
     * 用户希望从HTTP请求中获得什么，都可以从HttpServletRequest中获取
     *
     * HttpServletResponse response 表示HTTP响应：
     * 用户希望给客户端返回什么，都可以通过HttpServletResponse来返回
     * HttpServletResponse和HttpServletRequest是内置的，其他方法需要也可以加上
     *
     * 这种方式可以获取多个Cookie，这种在实际开发中非常常见
     *
     * Spring MVC 是基于Servlet API 构建的原始Web框架，也是Servlet的基础上实现的
     * HttpServletRequest，HttpServletResponse是Servlet提供的两个类，是Spring MVC
     * 方法的内置对象，需要时直接在方法中添加声明既可。
     * 1.HttpServletRequest 对象代表客户端的请求，当客户端通过HTTP协议访问服务器
     * 时，HTTP请求头中的所有信息都封装在这个对象中，通过这个对象提供的方法，可以
     * 获得客户端请求的所有信息
     * 2.HttpServletResponse对象代表服务器的响应，HTTP响应的信息都在这个对象中，比如
     * 向客户端发生的数据，响应头，状态码等，通过这个对象提供的方法，可以获得服务器响应的所有
     * 内容
     */
    @RequestMapping("/r13")
    public String r13(HttpServletRequest request/*, HttpServletResponse response*/){
/*        String name = request.getParameter("age");
        response.setContentType("text/html;charset=utf-8");*/
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue());

            }
        }
        return "返回cookie成功";
    }

    /*
     * @author MartinYang
     * @date 2025-10-10 22:07
     * @params:
     * @returns: java.lang.String
     * 使用注解的方法获得Cookie
     * @CookieValue使用这个进行cookie的参数绑定
     * 这种方式只能获取一个Cookie，这种在实际开发中并不常见
     */
    @RequestMapping("/r14")
    public String r14(@CookieValue("java") String java){
        return "从Cookie中获取Java的值： " + java;
    }

    /*
     * @author MartinYang
     * @date 2025-10-10 22:23
     * @params:
     * @returns: java.lang.String
     * 设置session
     * 从Cookie获取sessionID，根据sessionID,获取session对象
     * HttpSession getSession(boolean var1);
     * HttpSession getSession(); 默认为true
     * true：没有获取到session，返回一个空的session对象
     * false：没有获取到session，返回null
     * Cookie和session大多数用在用户登录上
     */
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){//存储session
        //从Cookie获取sessionID，根据sessionID,获取session对象
        //如果sessionId不存在，则创建
        HttpSession session = request.getSession();//这里获取不了，直接默认或者写true
        //设置session,session默认存储在内存中
        //登录的用户名称
        session.setAttribute("username","zhangsan");
        //session.setAttribute("password","123456");
        session.setAttribute("age",18);
        return "设置session成功";
    }


    /*
     * @author MartinYang
     * @date 2025-10-10 22:58
     * @params:获取session方式1
     * @returns: java.lang.String
     * 服务器内存中会存储很多的用户信息
     * 不同的地方发起的请求，会生成不同的sessionID
     *sessionId1 -->httpSession1
     * sessionId2 -->httpSession2
     */
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        //从Cookie获取sessionID，根据sessionID,获取session对象
        HttpSession session = request.getSession(false);
        //如果用户登录，session 有值，未登录，session为null
        if (session == null) {
            return "用户未登录";
        }else {
            //从session中获取登录信息
            String username = (String) session.getAttribute("username");
            return "登录用户为：" + username;
        }
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 01:23
     * @params:
     * @returns: java.lang.String
     * HttpSession 等同于request.getSession(true);|| request.getSession();
     * 没有session就帮我们进行创建,
     * 因为为true，没有为null的情况，不用判断session是否为空了
     */
    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session) {
            //从session中获取登录用户信息
            String username = (String) session.getAttribute("username");
            return "登录用户为：" + username;

    }

    /*
     * @author MartinYang
     * @date 2025-10-11 01:45
     * @params:
     * @returns: java.lang.String
     * 这里把什么 String username = (String) session.getAttribute("username");简化了
     */
    @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute("username") String username) {
            return "登录用户为：" + username;
    }


    /*
     * @author MartinYang
     * @date 2025-10-11 02:04
     * @params:获取Header方法1
     * @returns: java.lang.String
     *
     */
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "从Header中获取userAgent:" + userAgent;
    }


    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent")String userAgent){
        return "从Header中获取userAgent:" + userAgent;
    }



}
