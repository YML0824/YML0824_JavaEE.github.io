package com.yml.springblog.pojo.response;

import com.yml.springblog.enums.ResultCodeEnum;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 16:08
 */
@Data
public class Result {
    //业务状态码，非http状态码
    private ResultCodeEnum code;
    private String errMsg;
    private Object data;


    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail(String errMsg) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        return result;
    }

    public static Result fail(String errMsg, Object data) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

}
