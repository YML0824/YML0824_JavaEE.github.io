package com.yml.com.springlog.facade;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-22
 * Time: 20:46
 */
public class HallLight implements Light {
    @Override
    public void on() {
        System.out.println("打开走廊灯");
    }

    @Override
    public void off() {
        System.out.println("关闭走廊灯");

    }
}
