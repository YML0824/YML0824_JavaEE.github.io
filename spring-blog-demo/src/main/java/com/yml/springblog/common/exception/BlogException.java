package com.yml.springblog.common.exception;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 21:53
 */
@Data
public class BlogException extends RuntimeException{

    private int code;

    private String errMsg;

    public BlogException(String errMsg, int code) {
        this.errMsg = errMsg;
        this.code = code;
    }
    public BlogException(String errMsg) {
        this.errMsg = errMsg;
    }
}
