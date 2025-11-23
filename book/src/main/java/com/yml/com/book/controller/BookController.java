package com.yml.com.book.controller;

import com.yml.com.book.constant.Constants;
import com.yml.com.book.enums.BookStatusEnum;
import com.yml.com.book.enums.ResultCodeEnum;
import com.yml.com.book.model.*;
import com.yml.com.book.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-15
 * Time: 21:20
 * bookService 这个属性 就是 BookController 的依赖
 */
@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {

    /*
     * @author MartinYang
     * @date 2025-10-16 22:08
     * @params:@Autowired表示从Spring当中获取对象，并且把值赋给bookService
     * @returns:
     */
    @Autowired
    private BookService bookService;


    @PostMapping(value = "/addBook", produces = "application/json")
    public String addBook(BookInfo bookInfo){

        //日志一般在请求前和请求后添加
        log.info("添加图书，Request:" + bookInfo);//如果是+号可以不用
        log.info("添加图书，Request:{}" , bookInfo);//如果是加逗号需要把{}加上，{}这里是一个占位符
        //1.参数校验
        //2.存储数据
        //3.返回结果
        if(!StringUtils.hasLength(bookInfo.getBookName())){
            log.error("图书名为空：{}",bookInfo);
            return "图书名不能为空";
        }
        if(!StringUtils.hasLength(bookInfo.getAuthor())){
            log.error("图书作者输入为空：{}", bookInfo);
            return "图书的作者不能为空";
        }
        if(bookInfo.getCount() == null){
            log.error("图书数量输入为空：{}", bookInfo);
            return "图书数量不能为空";
        }
        if(bookInfo.getPrice()==null){
            log.error("图书价格为空：{}", bookInfo);
            return "图书价格不能为空";
        }
        if (!StringUtils.hasLength(bookInfo.getPublish())){
            log.error("出版社为空：{}", bookInfo);
            return "出版社不能为空";
        }
        if (bookInfo.getStatus()==null){
            log.error("设置状态错误，不合法 ，request:{}" , bookInfo);
            return "状态不能为空";

        }

        try{
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            //打印堆栈日志信息可以省略掉{}
            log.error("添加图书异常 e:" ,e);
            return "添加图书失败" ;
        }

    }

    @GetMapping("/getListByPage")
    public Result<ResponseResult<BookInfo>> getListByPage(PageRequest pageRequest, HttpSession session){
//        //参数校验
//        //返回数据
//        //从Cookie中获取sessionId，如果可以获得session信息，说明用户已登录
//        if(session.getAttribute(Constants.SESSION_USER_KEY) == null){
//            return Result.unlogin();
//        }
//        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//        if(userInfo==null || userInfo.getId() <= 0){
//            //用户未登录
//            return  Result.unlogin();
//        }
        ResponseResult<BookInfo> listByPage = bookService.getListByPage(pageRequest);
        return Result.success(listByPage);
    }

    @GetMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId){
        log.info("查询图书信息，bookId:{}" , bookId);
        return  bookService.queryBookById(bookId);
    }

    @PostMapping(value = "/updateBook")
    public Result updateBook(BookInfo bookInfo){
        log.info("修改图书信息 ，bookInfo:{}" , bookInfo);
        try{
            bookService.updateBook(bookInfo);
            return Result.success("");
        }catch (Exception e){
            log.info("修改图书发生异常，e: ",e);
            return Result.fail("修改图书发生异常");
        }
    }

    @PostMapping(value = "/deleteBook")
    public Result deleteBook(Integer bookId){
        log.info("删除图书信息 ，bookId:{}" , bookId);
        try{
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookStatusEnum.DELETED.getCode());
            bookService.updateBook(bookInfo);

            return Result.success("");
        }catch (Exception e){
            log.info("删除图书发生异常，e: ",e);
            return Result.fail("删除图书发生异常");
        }
    }

    @PostMapping("/batchDelete")
    public Boolean batchDelete(@RequestParam List<Integer> ids){
        log.info("批量删除图书， ids:{}",ids);
        try{
            bookService.batchDelete(ids);
            return true;
        }catch (Exception e){
            log.error("批量删除图书失败，e:",e);
            return false;
        }
    }

}
