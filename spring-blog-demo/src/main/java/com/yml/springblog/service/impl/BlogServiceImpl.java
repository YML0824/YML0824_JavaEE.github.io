package com.yml.springblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yml.springblog.common.constant.Constants;
import com.yml.springblog.common.exception.BlogException;
import com.yml.springblog.common.util.BeanTransUtils;
import com.yml.springblog.mapper.BlogInfoMapper;
import com.yml.springblog.pojo.dataobject.BlogInfo;
import com.yml.springblog.pojo.request.AddBlogRequest;
import com.yml.springblog.pojo.request.UpdateBlogRequest;
import com.yml.springblog.pojo.response.BlogInfoResponse;
import com.yml.springblog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-17
 * Time: 22:28
 */
@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getList() {

        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, Constants.BLOG_NORMAL);
        List<BlogInfo> blogInfos =  blogInfoMapper.selectList(queryWrapper);

        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream()
                .map(blogInfo -> BeanTransUtils.trans(blogInfo))
                .collect(Collectors.toList());
        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        return BeanTransUtils.trans(getBlogInfo(blogId));

    }

    @Override
    public BlogInfo getBlogInfo(Integer blogId) {
        LambdaQueryWrapper<BlogInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BlogInfo::getDeleteFlag,Constants.BLOG_NORMAL)
                .eq(BlogInfo::getId,blogId);
        return blogInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest,blogInfo);
        try{
            Integer result = blogInfoMapper.insert(blogInfo);
            if(result == 1){
                return true;
            }
            return false;
        }catch (Exception e){
            log.error("博客插入失败，e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }

    }

    @Override
    public Boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        BlogInfo blogInfo = BeanTransUtils.trans(updateBlogRequest);
        try{
            Integer result = blogInfoMapper.updateById(blogInfo);
//            if(result == 1){
//                return true;
//            }
//            return false;
            return  result == 1;
        }catch (Exception e){
            log.error("更新博客失败，e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }

    }

    @Override
    public Boolean deleteBlog(Integer blogId) {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(Constants.BLOG_DELETE);
        try{
            Integer result = blogInfoMapper.updateById(blogInfo);
            return  result == 1;
        }catch (Exception e){
            log.error("删除博客失败，e:",e);
            throw new BlogException("内部错误，请联系管理员");
        }

    }
}
