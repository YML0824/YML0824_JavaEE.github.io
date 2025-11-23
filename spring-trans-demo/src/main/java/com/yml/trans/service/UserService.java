package com.yml.trans.service;

import com.yml.trans.mapper.UserInfoMapper;
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
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer registryUser(String username,String password){
        //插⼊⽤⼾信息
        return userInfoMapper.insert(username,password);
    }
}
