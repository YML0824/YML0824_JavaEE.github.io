package com.yml.com.springlog.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:第二种方法
 * User: YY_ang
 * Date: 2025-10-22
 * Time: 19:59
 */
@Slf4j
@RequestMapping("/log2")
@RestController
public class LogController2 {

    /*
     * @author MartinYang
     * @date 2025-10-22 22:53
     * @params:
     * 默认级别是info
     * 级别低于info级别的都不打印
     *默认级别可以调整
        ⽇志的级别从⾼到低依次为: FATAL、ERROR、WARN、INFO、DEBUG、TRACE
        • FATAL: 致命信息，表⽰需要⽴即被处理的系统级错误.
        • ERROR: 错误信息, 级别较⾼的错误⽇志信息, 但仍然不影响系统的继续运⾏.
        • WARN: 警告信息, 不影响使⽤, 但需要注意的问题
        • INFO: 普通信息, ⽤于记录应⽤程序正常运⾏时的⼀些信息, 例如系统启动完成、请求处理完成等.
        • DEBUG: 调试信息, 需要调试时候的关键信息打印.
        • TRACE: 追踪信息, ⽐DEBUG更细粒度的信息事件(除⾮有特殊⽤意，否则请使⽤DEBUG级别替代)
     * @returns: java.lang.String
     */
    @RequestMapping("/print2")
    public String print(){
        System.out.println("sout打印日志");
        log.info("logger 打印日志");

        //TRACE: 追踪信息
        log.trace("logger trace");

        //• DEBUG: 调试信息
        log.debug("logger debug");

        //• INFO: 普通信息
        log.info("logger info");

        //• WARN: 警告信息
        log.warn("logger warn");

        //• ERROR: 错误信息
        log.error("logger error");


        return "打印日志";
    }


}
