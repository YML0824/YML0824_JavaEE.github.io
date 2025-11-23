package com.yml.springblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yml.springblog.common.exception.BlogException;
import com.yml.springblog.common.util.BeanTransUtils;
import com.yml.springblog.common.util.JwtUtils;
import com.yml.springblog.common.util.SecurityUtil;
import com.yml.springblog.mapper.UserInfoMapper;
import com.yml.springblog.pojo.dataobject.BlogInfo;
import com.yml.springblog.pojo.dataobject.UserInfo;
import com.yml.springblog.pojo.request.UserLoginRequest;
import com.yml.springblog.pojo.response.UserInfoResponse;
import com.yml.springblog.pojo.response.UserLoginResponse;
import com.yml.springblog.service.BlogService;
import com.yml.springblog.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:27
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {
        //查询数据库
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserName, userLoginRequest.getUserName())
                .eq(UserInfo::getDeleteFlag,0);
        //TODO try catch
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if(userInfo == null){
            throw new BlogException("用户不存在");
        }
        //判断密码是否正确
//        if(!userLoginRequest.getPassword().equals(userInfo.getPassword())){
//            throw  new BlogException("用户密码错误");
//        }
        if(!SecurityUtil.verify(userLoginRequest.getPassword(),userInfo.getPassword())){
            throw  new BlogException("用户密码错误");
        }

        //密码正确，返回一个Token
        Map<String,Object> map = new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("userName",userInfo.getUserName());
        String token = JwtUtils.genToken(map);

        return new UserLoginResponse(token,userInfo.getId());
    }

    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getDeleteFlag,0)
                .eq(UserInfo::getId,userId);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        return BeanTransUtils.trans(userInfo);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        //1.根据blogId 获取博客信息(包含作者id)
        BlogInfo blogInfo = blogService.getBlogInfo(blogId);
        if (blogInfo == null || blogInfo.getUserId()<=0){
            throw new BlogException("博客不存在");
        }
        //2.根据作者Id，获取作者信息
        return getUserInfo(blogInfo.getUserId());
    }
}
