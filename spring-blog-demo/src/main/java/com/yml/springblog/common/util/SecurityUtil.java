package com.yml.springblog.common.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-23
 * Time: 2:53
 */
public class SecurityUtil {
    /*
     * @author MartinYang
     * @date 2025-11-23 03:05
     * @params:
     * 加密
     * MD5(salt+明文)
     * @returns: 盐值+MD5(盐值+明文)
     */
    public static String encrypt(String password){
        String salt= UUID.randomUUID().toString().replace("-","");
        String securityPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        return salt+securityPassword;
    }

   /*
    * @author MartinYang
    * @date 2025-11-23 03:19
    * @params:
    *  验证密码
    * 数据库存储的是：盐值+MD5(盐值+明文)
    * @returns: java.lang.Boolean
    */
    public static Boolean verify(String inputPassword,String sqlPassword){
        if (!StringUtils.hasLength(inputPassword)){
            return false;
        }
        if(sqlPassword==null || sqlPassword.length() != 64){
            return false;
        }
        String salt = sqlPassword.substring(0, 32);
        String securityPassword = DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes(StandardCharsets.UTF_8));
        return sqlPassword.equals(salt+securityPassword);

    }


}
