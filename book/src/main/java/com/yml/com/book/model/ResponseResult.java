package com.yml.com.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-02
 * Time: 4:23
 */
//生成默认有参的构造函数
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult <T>{
    private Integer total;
    private List<T> records;
    private PageRequest pageRequest;
}
