package com.yml.com.book.model;

import com.yml.com.book.enums.ResultCodeEnum;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-03
 * Time: 12:13
 */
@Data
public class Result<T>{
    private ResultCodeEnum code;   //-1 未登录， 200 正常，-2出错
    private String errMsg;
    private T data;

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public  static <T> Result fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public  static <T> Result fail(String errMsg,T data){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

    public  static <T> Result unlogin(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }
}
