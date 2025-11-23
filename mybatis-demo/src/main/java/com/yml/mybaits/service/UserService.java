package com.yml.mybaits.service;

import com.yml.mybaits.mapper.UserInfoMapper;
import com.yml.mybaits.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-25
 * Time: 15:15
 */
@Service
public class UserService  {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAllUser() {
        return userInfoMapper.selectAll();
    }

    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.selectAllById2(id);
    }

    public List<UserInfo> getUserInfoById2(Integer id) {
        return userInfoMapper.selectAllById3(id);
    }

    /*
     * @author MartinYang
     * @date 2025-10-29 10:29
     * @params: SQL注入问题
     * @returns: com.yml.mybaits.model.UserInfo
     */
    public UserInfo queryUserByUserNameAndPassword(String userName, String password) {
        List<UserInfo> userInfos = userInfoMapper.selectByNameAndPassword2(userName, password);
        if (userInfos != null && userInfos.size() >= 1) {
            return userInfos.get(0);
        }
        return null;
    }
}
