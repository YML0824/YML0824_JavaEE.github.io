package com.yml.com.book.adapter;

/**
 * Created with IntelliJ IDEA.
 * Description:适配器模式实现
 * User: YY_ang
 * Date: 2025-11-09
 * Time: 16:37
 */
public class Log4jSlf4Adapter implements Slf4jApi {
    private Log4j log4j;

    public Log4jSlf4Adapter(Log4j log4j) {
        this.log4j = log4j;
    }
    @Override
    public void log(String log) {
        log4j.log("Log4jSlf4Adapter: " + log);
    }

}
