package com.yml.springblog.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-20
 * Time: 9:54
 */
@Slf4j
public class JwtUtils {

    private static String SECRET_STRING = "kOT5eO9qLyLW1I1gVN8Qu1BxD/eXl08ZQ77DQvqesR4=";

    private static  Key key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    public static String genToken(Map<String, Object> claims){
        String compact = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        return compact;
    }


    public static Claims parseToken(String token){
        if(!StringUtils.hasLength(token)){
            return null;
        }
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = null;
        try{
            claims = build.parseClaimsJws(token).getBody();
        }catch (Exception e){
            log.error("token解析失败，Token:{}",token);
        }

        return claims;
    }

}
