package com.yml.com.book.adapter;

/**
 * Created with IntelliJ IDEA.
 * Description:适配器模式实现
 * User: YY_ang
 * Date: 2025-11-09
 * Time: 16:48
 */
public class LogBackSlf4jAdapter implements Slf4jApi {

    private LogBack logBack;

    public LogBackSlf4jAdapter(LogBack logBack) {
        this.logBack = logBack;
    }
    @Override
    public void log(String log) {
        logBack.print("LogBackSlf4jAdapter: " + log);
    }
}
