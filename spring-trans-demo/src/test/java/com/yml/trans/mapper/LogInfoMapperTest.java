package com.yml.trans.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-16
 * Time: 1:28
 */
@SpringBootTest
class LogInfoMapperTest {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Test
    void insertLog() {
        logInfoMapper.insertLog("111","111");
    }
}