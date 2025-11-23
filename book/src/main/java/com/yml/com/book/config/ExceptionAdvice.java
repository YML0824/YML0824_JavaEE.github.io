package com.yml.com.book.config;

import com.yml.com.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * 统一异常处理使用的是 @ControllerAdvice + @ExceptionHandler
 * @ControllerAdvice 表示控制器通知类， @ExceptionHandler 是异常处理器
 * 两个结合表示当出现异常的时候执行某个通知，也就是执行某个方法
 * 类名，方法名和返回值可以自定义，重要的是注解
 * 接口返回为数据的时候，需要加@ResponseBody注解
 * User: YY_ang
 * Date: 2025-11-09
 * Time: 21:28
 */
@Slf4j
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class ExceptionAdvice {

    /*
     * @author MartinYang
     * @date 2025-11-10 08:51
     * @params:写法1
     * @returns:
     */
//    @ExceptionHandler
//    public Result handler(Exception e){
//        log.error("发生异常, e:",e);
//        return Result.fail("内部错误,请联系管理员");
//    }
//
//    @ExceptionHandler
//    public Result handler(NullPointerException e){
//        log.error("发生异常, e:",e);
//        return Result.fail("发生空指针异常,请联系管理员");
//    }
//    @ExceptionHandler
//    public Result handler(IndexOutOfBoundsException e){
//        log.error("发生异常, e:",e);
//        return Result.fail("数组越界异常,请联系管理员");
//    }


    /*
     * @author MartinYang
     * @date 2025-11-10 08:51
     * @params:写法2
     * @ExceptionHandler(Exception.class) 这里指定铺获的异常
     * @returns: com.yml.com.book.model.Result
     */
    @ExceptionHandler(Exception.class)
    public Result handler1(Exception e){
        log.error("发生异常, e:",e);
        return Result.fail("内部错误,请联系管理员");
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handler2(Exception e){
        log.error("发生异常, e:",e);
        return Result.fail("发生空指针异常,请联系管理员");
    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result handler3(Exception e){
        log.error("发生异常, e:",e);
        return Result.fail("数组越界异常,请联系管理员");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public Result handleNoResourceFoundException(NoResourceFoundException e) {
        // 对于 .well-known 路径的请求，静默处理
        if (e.getResourcePath() != null && e.getResourcePath().contains(".well-known")) {
            log.debug("请求的静态资源不存在: {}", e.getResourcePath());
            return Result.fail("资源未找到", 404);
        }

        // 对于其他静态资源请求
        log.debug("静态资源未找到: {}", e.getResourcePath());
        return Result.fail("资源未找到", 404);
    }





}
