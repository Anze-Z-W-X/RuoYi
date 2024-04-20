//package com.thirteen.smon.system.domain.entity;
//
//
//import java.io.Serializable;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.ruoyi.common.annotation.Excel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
///**
// * (PostsTheme)表实体类
// *
// * @author makejava
// * @since 2024-04-19 10:47:24
// */
//@SuppressWarnings("serial")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@TableName("mrds_posts_theme")
//public class PostsTheme  {
//    private static final long serialVersionUID = 1L;
//
//    @TableId(type = IdType.AUTO)
//    private Integer id;
//
//    @Excel(name = "性别 1 男；2 女")
//    private Integer sex;
//    //主题名称
//    @Excel(name = "主题名称")
//    private String title;
//    //封面图片
//    @Excel(name = "封面图片")
//    private String coverUrl;
//    //描述
//    @Excel(name = "描述")
//    private String description;
//    //主题开始时间
//    @Excel(name = "主题开始时间")
//    private Long startAt;
//    //主题结束时间
//    @Excel(name = "主题结束时间")
//    private Long endAt;
//    //主题下帖子数量
//    @Excel(name = "主题下帖子数量")
//    private Integer postsNums;
//    //状态 10 上架中 0 下架
//    @Excel(name = "状态 10 上架中 0 下架")
//    private Integer status;
//    //创建时间
//    @Excel(name = "创建时间")
//    private Long createdAt;
//    //更新时间
//    @Excel(name = "更新时间")
//    private Long updatedAt;
//
//}
//
