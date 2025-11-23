package com.bite.springdemo;

import com.bite.springdemo.model.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-09
 * Time: 16:54
 */
public class JsonTest {
    @Test
    public void testObjectToJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //创建一个Java对象
        UserInfo userInfo = new UserInfo("zhangsan", 22, 33);

        //对象转JSON
        String s = objectMapper.writeValueAsString(userInfo);
        System.out.println(s);
    }



    @Test
    public void testJsonToObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //定义一个Json字符串
        String s = "{\"name\":\"zhangsan\",\"gender\":1,\"age\":18}";

        //Json转对象
        UserInfo userInfo = objectMapper.readValue(s, UserInfo.class);
        System.out.println(userInfo);
    }

}
