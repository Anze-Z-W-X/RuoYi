//package com.thirteen.smon.system.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.thirteen.smon.system.domain.entity.PostsTheme;
//import com.thirteen.smon.system.domain.enums.AppHttpCodeEnum;
//import com.thirteen.smon.system.domain.exception.SystemException;
//import com.thirteen.smon.system.domain.respone.ResponseResult;
//import com.thirteen.smon.system.mapper.PostsThemeMapper;
//import com.thirteen.smon.system.service.PostsThemeService;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//
///**
// * (PostsTheme)表服务实现类
// *
// * @author makejava
// * @since 2024-04-19 10:47:26
// */
//@Service
//public class PostsThemeServiceImpl extends ServiceImpl<PostsThemeMapper, PostsTheme> implements PostsThemeService {
//
//    @Resource
//    private PostsThemeMapper postsThemeMapper;
//
//    @Override
//    public List<PostsTheme> getPostsList() {
//        LambdaQueryWrapper<PostsTheme> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(PostsTheme::getStatus,10);
//        Page<PostsTheme> page = new Page<>(1,10);
//        page(page,wrapper);
//        return page.getRecords();
//    }
//
//    @Override
//    public int addPostsTheme(PostsTheme postsTheme) {
//        postsTheme.setCreatedAt(new Date().getTime());
//        postsTheme.setUpdatedAt(new Date().getTime());
//        save(postsTheme);
//        return postsThemeMapper.insertPostsTheme(postsTheme);
//    }
//
//    @Override
//    public int updatePostsTheme(PostsTheme postsTheme) {
//        postsTheme.setUpdatedAt(new Date().getTime());
//        return postsThemeMapper.updatePostsTheme(postsTheme);
//    }
//
//    @Override
//    public int deletePostsTheme(Long[] ids) {
//        return postsThemeMapper.deletePostsThemeById(ids);
//    }
//
//    @Override
//    public PostsTheme selectPostsThemeById(Long id) {
//        return postsThemeMapper.selectById(id);
//    }
//
//    @Override
//    public List<PostsTheme> selectPostsThemeList(PostsTheme postsTheme) {
//        return postsThemeMapper.selectPostsThemeList(postsTheme);
//    }
//
//
//}
