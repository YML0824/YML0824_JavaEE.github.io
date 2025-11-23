package com.yml.com.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-21
 * Time: 13:41
 */
public class CaptchaTest {
    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("C:\\Users\\YY_ang\\Desktop\\C\\line.png");

        //输出code
        System.out.println(lineCaptcha.getCode());
        //Console.log(lineCaptcha.getCode());

        //验证图形验证码的有效性，返回Boolean值
        System.out.println(lineCaptcha.verify("1234567890"));




        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        //CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("C:\\Users\\YY_ang\\Desktop\\C\\circle.png");
    }
}
