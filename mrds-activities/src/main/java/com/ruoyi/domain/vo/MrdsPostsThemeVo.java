package com.ruoyi.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MrdsPostsThemeVo {
    private Long id;

    /** 性别 1 男；2 女 */
    @Excel(name = "性别 1 男；2 女")
    private Integer sex;

    /** 主题名称 */
    @Excel(name = "主题名称")
    private String title;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String coverUrl;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 主题开始时间 */
    @Excel(name = "主题开始时间")
    private String startAt;

    /** 主题结束时间 */
    @Excel(name = "主题结束时间")
    private String endAt;

    /** 主题下帖子数量 */
    @Excel(name = "主题下帖子数量")
    private Long postsNums;

    /** 状态 10 上架中 0 下架 */
    @Excel(name = "状态 10 上架中 0 下架")
    private Integer status;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createdAt;

    /** 更新时间 */
    @Excel(name = "更新时间")
    private String updatedAt;
}
