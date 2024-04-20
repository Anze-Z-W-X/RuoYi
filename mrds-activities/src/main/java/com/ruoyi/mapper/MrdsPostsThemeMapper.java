package com.ruoyi.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.domain.MrdsPostsTheme;

/**
 * 活动管理Mapper接口
 *
 * @author Anze_xuu
 * @date 2024-04-19
 */
public interface MrdsPostsThemeMapper extends BaseMapper<MrdsPostsTheme>
{
    /**
     * 查询活动管理
     *
     * @param id 活动管理主键
     * @return 活动管理
     */
    public MrdsPostsTheme selectMrdsPostsThemeById(Long id);

    /**
     * 查询活动管理列表
     *
     * @param mrdsPostsTheme 活动管理
     * @return 活动管理集合
     */
    public List<MrdsPostsTheme> selectMrdsPostsThemeList(MrdsPostsTheme mrdsPostsTheme);

    /**
     * 新增活动管理
     *
     * @param mrdsPostsTheme 活动管理
     * @return 结果
     */
    public int insertMrdsPostsTheme(MrdsPostsTheme mrdsPostsTheme);

    /**
     * 修改活动管理
     *
     * @param mrdsPostsTheme 活动管理
     * @return 结果
     */
    public int updateMrdsPostsTheme(MrdsPostsTheme mrdsPostsTheme);

    /**
     * 删除活动管理
     *
     * @param id 活动管理主键
     * @return 结果
     */
    public int deleteMrdsPostsThemeById(Long id);

    /**
     * 批量删除活动管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMrdsPostsThemeByIds(Long[] ids);
}
