package com.yml.com.captcha.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.yml.com.captcha.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:生成验证码
 * User: YY_ang
 * Date: 2025-10-21
 * Time: 16:33
 */

@RequestMapping("/captcha")
@RestController
public class CaptchaController {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    @Autowired
    private CaptchaProperties captchaProperties;

    //定义一个过期时间,一分钟
    private final static Long VALID_TIME = 30 * 60 * 1000L;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session,HttpServletResponse response){
        long start = System.currentTimeMillis();
        //response 一般写在最前面，写在使用response之前
        response.setContentType("image/jpeg");
        //一般情况下，这个处理是前端的，后端不做处理
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            //生成验证码
            ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(captchaProperties.getWidth(),
                    captchaProperties.getHeight());
            String code = captcha.getCode();
            session.setAttribute(captchaProperties.getSession().getKey(), code );
            //public Date() {
            //        this(System.currentTimeMillis());
            //    }
            //new Date的时候调用了系统的时间方法，为当前的时间
            session.setAttribute(captchaProperties.getSession().getDate(),new Date());//存储当前时间
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        //System.out.println("getCaptcha cost time " + (end - start) + "ms");
        logger.info("getCaptcha cost time " + (end - start) + "ms");
    }


    /*
     * @author MartinYang
     * 验证用户输入的验证码是否正确
     * @date 2025-10-21 17:27
     * @params: captcha 用户输入验证码
     * @returns: boolean
     */

    @RequestMapping("/check")
    public boolean check(String captcha, HttpSession session) {
        //进行验证码判断非空
        if(! StringUtils.hasLength(captcha)){
            return false;
        }
        //获取一开始验证码生成，返回验证码时间
        Date date = (Date) session.getAttribute(captchaProperties.getSession().getDate());
        //验证验证码
        String code = (String) session.getAttribute(captchaProperties.getSession().getKey());

        /*
         * @author MartinYang
         * @date 2025-10-21 18:52
         * @params:
         * @returns: boolean
         * captcha.equalsIgnoreCase(code)   忽略大小写进行对比
         * System.currentTimeMillis()获取当前系统返回的时间
         * 和校验验证码时间是否过期
         */
        if(captcha.equalsIgnoreCase(code) && date != null && System.currentTimeMillis() - date.getTime() < VALID_TIME){
            return true;
        }
        return false;
    }
}
