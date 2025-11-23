package com.yml.springblog.service;

import com.yml.springblog.pojo.dataobject.BlogInfo;
import com.yml.springblog.pojo.request.AddBlogRequest;
import com.yml.springblog.pojo.request.UpdateBlogRequest;
import com.yml.springblog.pojo.response.BlogInfoResponse;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:50
 */
public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogDetail(Integer blogId);

    BlogInfo getBlogInfo(Integer blogId);

    Boolean addBlog(AddBlogRequest addBlogRequest);

    Boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    Boolean deleteBlog(@NotNull(message = "id不能为null") Integer blogId);
}
