package com.yml.trans.controller;

import com.yml.trans.service.LogService;
import com.yml.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:38
 */
@Slf4j
@RestController
@RequestMapping("/user2")
public class UserController2 {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    /*
     * @Transactional注解
     * 1.程序正常执行时，事务得到提交
     * 2.程序发生异常时，事务进行回滚
     * 如果异常进行捕获了，事务正常提交,但是异常如果重新抛出，事务还是会进行回滚
     * 或者手动设置回滚
     */
    @Transactional
    @RequestMapping("/registry2")
    public String registry(String username,String password){
        //用户注册
        Integer result = userService.registryUser(username, password);
        log.info("用户注册成功,游戏行数：{}",result);
        try {
            int a = 10/0;
        }catch (Exception e){
            log.error("程序发生异常");
            //throw new RuntimeException(e);
            //如果不想抛出异常影响页面的访问，就手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "success";

    }



    /*
     * @author MartinYang
     * @date 2025-11-16 16:03
     * @params:
     * @returns:
     * 事务会回滚
     */

    @Transactional(rollbackFor=Exception.class)
    @RequestMapping("/r2")
    public String r2(String username,String password) throws IOException {
        //用户注册
        Integer result = userService.registryUser(username, password);
        log.info("用户注册成功,游戏行数：{}",result);
        if(true){
            throw new IOException();
        }
        return "success";

    }

    /*
     * @author MartinYang
     * @date 2025-11-16 16:03
     * @params:
     * @returns: java.lang.String
     *
     * 事务不会回滚
     */
    @Transactional
    @RequestMapping("/r3")
    public String r3(String username,String password) throws IOException {
        //用户注册
        Integer result = userService.registryUser(username, password);
        log.info("用户注册成功,游戏行数：{}",result);
        if(true){
            throw new IOException();
        }
        return "success";

    }

    /*
     * @author MartinYang
     * @date 2025-11-16 17:28
     * @params:
     * @returns: java.lang.String
     *
     * isolation = Isolation.DEFAULT  这里代表设置默认的隔离级别，数据库使用什么隔离级别，这里默认就是
     * Isolation.READ_COMMITTED 读已提交
     */
    //@Transactional(isolation = Isolation.DEFAULT)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @RequestMapping("/r4")
    public String r4(String username,String password) throws IOException {
        //用户注册
        Integer result = userService.registryUser(username, password);
        log.info("用户注册成功,游戏行数：{}",result);
        if(true){
            throw new IOException();
        }
        return "success";

    }


    /*
     * @author MartinYang
     * @date 2025-11-16 18:18
     * @params:
     * @returns: java.lang.String
     *
     * 事务的传播机制
     * @Transactional 这里如果不写传播机制默认是:
     *         propagation = Propagation.REQUIRED
     * 一个发生异常整个事务都会回滚，这个就是REQUIRED
     */
    @Transactional()
    @RequestMapping("/r5")
    public String r5(String username,String password) {
        //用户注册
        Integer result = userService.registryUser(username, password);
        log.info("用户注册成功,游戏行数：{}",result);
        Integer logResult = logService.insertLog(username,"用户注册");
        log.info("日志记录成功,游戏行数：{}",logResult);
        return "注册成功";

    }

}
