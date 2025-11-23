package com.yml.com.book.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-03
 * Time: 12:25
 */
public enum ResultCodeEnum {
    UNLOGIN(-1),
    SUCCESS(200),
    FAIL(-1);
    private int code;
    ResultCodeEnum(int code){
        this.code = code;
    }
}
