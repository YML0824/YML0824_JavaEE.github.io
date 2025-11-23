package com.yml.springblog.common.advice;

import com.yml.springblog.common.exception.BlogException;
import com.yml.springblog.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 21:57
 * @ResponseBody这个默认返回的数据，如果不加这个默认会认为返回的是页面，所有会找不着就会报错
 * 加上就不会报错
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler(Exception exception) {
        log.error("发生异常 e",exception);
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(BlogException exception) {
        log.error("发生异常 e",exception);
        return Result.fail(exception.getErrMsg());
    }

    @ExceptionHandler
    public Result exceptionHandler(HandlerMethodValidationException exception) {
        log.error("发生异常 e:{}",exception.getMessage());
        return Result.fail("参数校验失败");
    }

    @ExceptionHandler
    public Result exceptionHandler(MethodArgumentNotValidException exception) {
        //TODO 空指针判断
        String msg = exception.getBindingResult().getFieldError().getDefaultMessage();
        log.error("发生异常 e:{}",exception.getMessage());
        return Result.fail(msg);
    }
}
