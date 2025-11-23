package com.yml.trans.service;

import com.yml.trans.mapper.LogInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:32
 */
@Slf4j
@Service
public class LogService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertLog(String username,String op){
        //记录⽤⼾操作
        int result =  logInfoMapper.insertLog(username,op);
        //事务发生异常
        int a = 10/0;
        return result;
    }

}
