//package com.thirteen.smon.system.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.thirteen.smon.system.domain.entity.PostsTheme;
//import org.apache.ibatis.annotations.Update;
//
//import java.util.List;
//
//
///**
// * (PostsTheme)表数据库访问层
// *
// * @author makejava
// * @since 2024-04-19 10:47:23
// */
//public interface PostsThemeMapper extends BaseMapper<PostsTheme> {
//    @Update("update mrds_posts_theme set status=0,updatedAt=#{upTime} where id=#{id}")
//    void deletePostsTheme(Integer id,Long upTime);
//
//    List<PostsTheme> selectPostsThemeList(PostsTheme postsTheme);
//
//    int insertPostsTheme(PostsTheme postsTheme);
//
//    int updatePostsTheme(PostsTheme postsTheme);
//
//    int deletePostsThemeById(Integer[] ids);
//}
