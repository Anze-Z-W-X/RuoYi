package com.ruoyi.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动管理对象 mrds_posts_theme
 *
 * @author Anze_xuu
 * @date 2024-04-19
 */
public class MrdsPostsTheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId
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
    private Long startAt;

    /** 主题结束时间 */
    @Excel(name = "主题结束时间")
    private Long endAt;

    /** 主题下帖子数量 */
    @Excel(name = "主题下帖子数量")
    private Long postsNums;

    /** 状态 10 上架中 0 下架 */
    @Excel(name = "状态 10 上架中 0 下架")
    private Integer status;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createdAt;

    /** 更新时间 */
    @Excel(name = "更新时间")
    private Long updatedAt;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Integer getSex()
    {
        return sex;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCoverUrl(String coverUrl)
    {
        this.coverUrl = coverUrl;
    }

    public String getCoverUrl()
    {
        return coverUrl;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setStartAt(Long startAt)
    {
        this.startAt = startAt;
    }

    public Long getStartAt()
    {
        return startAt;
    }
    public void setEndAt(Long endAt)
    {
        this.endAt = endAt;
    }

    public Long getEndAt()
    {
        return endAt;
    }
    public void setPostsNums(Long postsNums)
    {
        this.postsNums = postsNums;
    }

    public Long getPostsNums()
    {
        return postsNums;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setCreatedAt(Long createdAt)
    {
        this.createdAt = createdAt;
    }

    public Long getCreatedAt()
    {
        return createdAt;
    }
    public void setUpdatedAt(Long updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedAt()
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sex", getSex())
            .append("title", getTitle())
            .append("coverUrl", getCoverUrl())
            .append("description", getDescription())
            .append("startAt", getStartAt())
            .append("endAt", getEndAt())
            .append("postsNums", getPostsNums())
            .append("status", getStatus())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
