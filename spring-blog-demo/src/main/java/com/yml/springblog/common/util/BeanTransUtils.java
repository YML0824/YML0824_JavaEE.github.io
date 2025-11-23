package com.yml.springblog.common.util;

import com.yml.springblog.pojo.dataobject.BlogInfo;
import com.yml.springblog.pojo.dataobject.UserInfo;
import com.yml.springblog.pojo.request.UpdateBlogRequest;
import com.yml.springblog.pojo.response.BlogInfoResponse;
import com.yml.springblog.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-19
 * Time: 17:32
 */
public class BeanTransUtils {
    public static BlogInfoResponse trans(BlogInfo  blogInfo){
        if(blogInfo == null){
            //TODO 待做事项
            return null;
        }
        BlogInfoResponse blogInfoResponse = new BlogInfoResponse();

        //数据转换方法
        //源：blogInfo 目标： response
        BeanUtils.copyProperties(blogInfo, blogInfoResponse);
        return blogInfoResponse;
    }
    public static UserInfoResponse trans(UserInfo userInfo){
        if(userInfo == null){
            //TODO 待做事项
            return null;
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();

        //数据转换方法
        //源：blogInfo 目标： response
        BeanUtils.copyProperties(userInfo, userInfoResponse);
        return userInfoResponse;
    }

    public static BlogInfo trans(UpdateBlogRequest updateBlogRequest){
        if(updateBlogRequest == null){
            return null;
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest,blogInfo);
        return blogInfo;

    }

}
