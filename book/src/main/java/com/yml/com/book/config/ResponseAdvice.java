package com.yml.com.book.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yml.com.book.model.BookInfo;
import com.yml.com.book.model.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description:统一功能处理
 * User: YY_ang
 * Date: 2025-11-09
 * Time: 17:45
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    //是否进行处理
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //false ：表示不处理   true：表示处理
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof String){

            return objectMapper.writeValueAsString(Result.success(body));

        }
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
