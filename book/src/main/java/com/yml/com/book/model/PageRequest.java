package com.yml.com.book.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-02
 * Time: 4:31
 */
@Data
public class PageRequest {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
    private Integer offset ;

    public Integer getOffset() {
        return (currentPage -1 )*pageSize ;
    }
}
