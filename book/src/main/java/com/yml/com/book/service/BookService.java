package com.yml.com.book.service;

import com.yml.com.book.enums.BookStatusEnum;
import com.yml.com.book.mapper.BookMapper;
import com.yml.com.book.model.BookInfo;
import com.yml.com.book.model.PageRequest;
import com.yml.com.book.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 9:32
 * 加上@Component Spring 自动帮BookService 创建对象
 * 加上@Component 表示将BookService这个类交给Spring管理
 */
@Service
public class BookService {

    /*
     * @author MartinYang
     * @date 2025-10-16 22:11
     * @params:@Autowired表示从Spring容器当中获取对象，并且把值赋给bookDao
     * @returns:
     *
     * bookDao 是BookService一个属性,也是它的依赖
     */
    @Autowired
    private BookMapper bookMapper;

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }

    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest) {
        //1.获取总图书数
        //2.获取当前页的数据
        Integer count = bookMapper.count();
        List<BookInfo> bookInfos= bookMapper.selectBookByPage(pageRequest);
        //对数据进行二次处理
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }
        return new ResponseResult<>(count,bookInfos,pageRequest);
    }

    public BookInfo queryBookById(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids) {
        return bookMapper.batchDelete(ids);
    }
}
