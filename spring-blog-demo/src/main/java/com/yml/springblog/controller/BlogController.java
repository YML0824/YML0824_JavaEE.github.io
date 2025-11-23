package com.yml.springblog.controller;


import com.yml.springblog.pojo.request.AddBlogRequest;
import com.yml.springblog.pojo.request.UpdateBlogRequest;
import com.yml.springblog.pojo.response.BlogInfoResponse;
import com.yml.springblog.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:26
 */
@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {

    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList(){
        log.info("获取博客列表.......");
        List<BlogInfoResponse> blogInfos = blogService.getList();
        return blogInfos;
    }

    /*
     * @author MartinYang
     * @date 2025-11-22 15:46
     * 获取博客详情
     * @params:blogId 博客Id
     * @returns: 博客详情
     */
    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull(message = "blogId不能为null") Integer blogId){
        log.info("获取博客详情，blogId:{}",blogId);
        return blogService.getBlogDetail(blogId);
    }

    /*
     * @author MartinYang
     * @date 2025-11-22 15:45
     * 添加博客
     * @returns:
     */
    @RequestMapping("/add")
    public  Boolean addBlog(@RequestBody @Validated AddBlogRequest addBlogRequest){
        log.info("发布博客，userId:{},title:{}",addBlogRequest.getUserId(),addBlogRequest.getTitle());
        return blogService.addBlog(addBlogRequest);
    }

    /*
     * @author MartinYang
     * @date 2025-11-22 18:23
     * 编辑博客
     * @returns:
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody @Validated UpdateBlogRequest updateBlogRequest){
        log.info("更新博客，request:{}",updateBlogRequest);
        return blogService.updateBlog(updateBlogRequest);
    }

    @RequestMapping("/delete")
    public Boolean delete(@NotNull(message = "id不能为null") Integer blogId){
        log.info("删除博客，id:{}",blogId);
        return blogService.deleteBlog(blogId);

    }



}
