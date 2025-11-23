package com.yml.springblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 16:22
 */
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200),
    FAIL(-1);

    @Getter @Setter
    private int code;
}
