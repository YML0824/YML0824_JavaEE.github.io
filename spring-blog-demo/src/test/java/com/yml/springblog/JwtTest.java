package com.yml.springblog;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:JWT生成令牌
 * User: YY_ang
 * Date: 2025-11-20
 * Time: 8:50
 *eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6MTJ9.RZE6ZDar7cb94kjPawfzeBv6dHFgBUztcrz_xlBgjeg
 * eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6MTJ9.RZE6ZDar7cb94kjPawfzeBv6dHFgBUztcrz_xlBgjeg
 */
@SpringBootTest
public class JwtTest {
    @Test
    void genToken(){
        Key key = Keys.hmacShaKeyFor("kOT5eO9qLyLW1I1gVN8Qu1BxD/eXl08ZQ77DQvqesR4=".getBytes(StandardCharsets.UTF_8));
        //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        //1.创建claims(声明)集合
        Map<String,Object> claims = new HashMap<>();
        //2.向claims中添加自定义数据
        claims.put("id",12);
        claims.put("name","zhangsan");

        String compact = Jwts.builder() //创建JWT构造器
                .setClaims(claims)      //设置声明信息
                .signWith(key)
                .compact();             //生成紧凑的JWT字符串

        //输出结果
        System.out.println(compact);

//        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
//        System.out.println(build.parse(compact).getBody());
    }

    @Test
    void genKey(){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encoded = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(encoded);
    }


}
