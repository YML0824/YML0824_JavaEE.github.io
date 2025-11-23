package com.yml.com.book.mapper;

import com.yml.com.book.model.BookInfo;
import com.yml.com.book.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 23:06
 */
@Mapper
public interface BookMapper {

    @Insert("insert into  book_info(book_name,author,count,price,publish,status)" +
            " values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("select * from book_info where status != 0 limit #{offset},#{pageSize} ")
    List<BookInfo> selectBookByPage(PageRequest pageRequest);


    @Select("select count(1) from book_info where status != 0 ")
    Integer count();

    @Select("select * from book_info where status != 0 and id = #{bookId} ")
    BookInfo queryBookById(Integer bookId);


    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(List<Integer> ids);
}
