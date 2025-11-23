package com.yml.com.book.adapter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-09
 * Time: 16:54
 */
public class client {
    public static void main(String[] args) {
        Slf4jApi slf4jApi = new LogBackSlf4jAdapter(new LogBack());
        slf4jApi.log("我是日志");
    }
}
