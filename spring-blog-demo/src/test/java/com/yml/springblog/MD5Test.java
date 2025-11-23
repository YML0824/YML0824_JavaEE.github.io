package com.yml.springblog;

import com.yml.springblog.common.util.SecurityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-23
 * Time: 2:46
 */
@SpringBootTest
public class MD5Test {
    @Test
    public void encrypt(){
        String password = "123456";
        String salt = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(salt);
        String s2 = DigestUtils.md5DigestAsHex((salt + password).getBytes(StandardCharsets.UTF_8));
        System.out.println(s2);
    }

    @Test
    public void check(){
        String sqlPassword = "e671b34cb8294467976278b1f393404ce9fd59843b7e41db68579bd20cf8ca3d";
        String inputPassword = "123456";
        String salt = sqlPassword.substring(0,32);
        String s =  DigestUtils.md5DigestAsHex((salt + inputPassword).getBytes(StandardCharsets.UTF_8));
        System.out.println(sqlPassword.equals(salt+s));
    }

    @Test
    public void test(){
        String encrypt = SecurityUtil.encrypt("123456");
        System.out.println(encrypt);
        Boolean verify = SecurityUtil.verify("123456", encrypt);
        System.out.println(verify);
    }
}
