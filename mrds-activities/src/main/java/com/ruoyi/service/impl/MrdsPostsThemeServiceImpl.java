package com.ruoyi.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.MrdsPostsThemeMapper;
import com.ruoyi.domain.MrdsPostsTheme;
import com.ruoyi.service.IMrdsPostsThemeService;

import javax.annotation.Resource;

/**
 * 活动管理Service业务层处理
 *
 * @author Anze_xuu
 * @date 2024-04-19
 */
@Service
public class MrdsPostsThemeServiceImpl extends ServiceImpl<MrdsPostsThemeMapper, MrdsPostsTheme> implements IMrdsPostsThemeService
{
    @Resource
    private MrdsPostsThemeMapper mrdsPostsThemeMapper;

    /**
     * 查询活动管理
     *
     * @param id 活动管理主键
     * @return 活动管理
     */
    @Override
    public MrdsPostsTheme selectMrdsPostsThemeById(Long id)
    {
        return mrdsPostsThemeMapper.selectMrdsPostsThemeById(id);
    }

    /**
     * 查询活动管理列表
     *
     * @param mrdsPostsTheme 活动管理
     * @return 活动管理
     */
    @Override
    public List<MrdsPostsTheme> selectMrdsPostsThemeList(MrdsPostsTheme mrdsPostsTheme)
    {
        return mrdsPostsThemeMapper.selectMrdsPostsThemeList(mrdsPostsTheme);
    }

    /**
     * 新增活动管理
     *
     * @param mrdsPostsTheme 活动管理
     * @return 结果
     */
    @Override
    public int insertMrdsPostsTheme(MrdsPostsTheme mrdsPostsTheme)
    {
        mrdsPostsTheme.setCreatedAt(new Date().getTime());
        mrdsPostsTheme.setUpdatedAt(new Date().getTime());
        return mrdsPostsThemeMapper.insertMrdsPostsTheme(mrdsPostsTheme);
    }

    /**
     * 修改活动管理
     *
     * @param mrdsPostsTheme 活动管理
     * @return 结果
     */
    @Override
    public int updateMrdsPostsTheme(MrdsPostsTheme mrdsPostsTheme)
    {
        mrdsPostsTheme.setUpdatedAt(new Date().getTime());
        return mrdsPostsThemeMapper.updateMrdsPostsTheme(mrdsPostsTheme);
    }

    /**
     * 批量删除活动管理
     *
     * @param ids 需要删除的活动管理主键
     * @return 结果
     */
    @Override
    public int deleteMrdsPostsThemeByIds(Long[] ids)
    {
        return mrdsPostsThemeMapper.deleteMrdsPostsThemeByIds(ids);
    }

    /**
     * 删除活动管理信息
     *
     * @param id 活动管理主键
     * @return 结果
     */
    @Override
    public int deleteMrdsPostsThemeById(Long id)
    {
        return mrdsPostsThemeMapper.deleteMrdsPostsThemeById(id);
    }
}
