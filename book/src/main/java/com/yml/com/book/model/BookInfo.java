package com.yml.com.book.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-15
 * Time: 21:02
 */
@Data
public class BookInfo {

    private Integer id;

    private String bookName;

    private String author;

    private Integer count;

    private BigDecimal price;

    private String publish;//出版社

    private Integer status;//状态

    private Date createTime;

    private Date updateTime;

    private String statusCN;

}
