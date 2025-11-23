package com.yml.trans.controller;

import com.yml.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:38
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/registry")
    public String registry(String username,String password){
        /*
         * 手动的方法
         * 1.开启事务
         * 2.数据操作
         * 3.事务提交/回滚
         */

        //开启事务,拿到当前事务的状态,就是保存一下操作数据之前的数据
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        //用户注册
        userService.registryUser(username,password);
        log.info("用户注册成功");
        //事务的提交
//        dataSourceTransactionManager.commit(transaction);

        //事务的回滚
        dataSourceTransactionManager.rollback(transaction);
        return "success";

    }


}
