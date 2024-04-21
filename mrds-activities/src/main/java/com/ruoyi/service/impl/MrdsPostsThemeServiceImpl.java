package com.ruoyi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.mrds.bean.BeanCopyUtils;
import com.ruoyi.common.utils.mrds.date.ChangeDateUtils;
import com.ruoyi.common.utils.mrds.url.CoverUrlUtils;
import com.ruoyi.domain.vo.MrdsPostsThemeVo;
import org.springframework.stereotype.Service;
import com.ruoyi.mapper.MrdsPostsThemeMapper;
import com.ruoyi.domain.entity.MrdsPostsTheme;
import com.ruoyi.service.IMrdsPostsThemeService;
import org.springframework.util.ObjectUtils;

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
    public MrdsPostsThemeVo selectMrdsPostsThemeById(Long id)
    {
        MrdsPostsTheme mrdsPostsTheme = mrdsPostsThemeMapper.selectMrdsPostsThemeById(id);
        mrdsPostsTheme.setCoverUrl(CoverUrlUtils.getCoverUrl(mrdsPostsTheme.getCoverUrl()));
        return changeToVo(mrdsPostsTheme);
    }

    /**
     * 查询活动管理列表
     *
     * @param mrdsPostsTheme 活动管理
     * @return 活动管理
     */
    @Override
    public List<MrdsPostsThemeVo> selectMrdsPostsThemeList(MrdsPostsTheme mrdsPostsTheme)
    {
        PageHelper.startPage(1,10);
        List<MrdsPostsTheme> mrdsPostsThemes = mrdsPostsThemeMapper.selectMrdsPostsThemeList(mrdsPostsTheme);
        PageInfo<MrdsPostsTheme> pageInfo = new PageInfo<>(mrdsPostsThemes);
        mrdsPostsThemes = pageInfo.getList();
        List<MrdsPostsThemeVo> mrdsPostsThemeVos = new ArrayList<>();
        if(!ObjectUtils.isEmpty(mrdsPostsThemes)){
            mrdsPostsThemes.forEach(m -> {
                m.setCoverUrl(CoverUrlUtils.getCoverUrl(m.getCoverUrl()));
                mrdsPostsThemeVos.add(changeToVo(m));
            });
        }
        return mrdsPostsThemeVos;
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
        mrdsPostsTheme.setCreatedAt(ChangeDateUtils.getCurrentUnixTime());
        mrdsPostsTheme.setUpdatedAt(ChangeDateUtils.getCurrentUnixTime());
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
        mrdsPostsTheme.setUpdatedAt(ChangeDateUtils.getCurrentUnixTime());
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


    public MrdsPostsThemeVo changeToVo(MrdsPostsTheme mrdsPostsTheme){
        MrdsPostsThemeVo mrdsPostsThemeVo = BeanCopyUtils.copyBean(mrdsPostsTheme,MrdsPostsThemeVo.class);
        mrdsPostsThemeVo.setStartAt(ChangeDateUtils.getUnixTransferTime(mrdsPostsTheme.getStartAt()));
        mrdsPostsThemeVo.setEndAt(ChangeDateUtils.getUnixTransferTime(mrdsPostsTheme.getEndAt()));
        mrdsPostsThemeVo.setCreatedAt(ChangeDateUtils.getUnixTransferTime(mrdsPostsTheme.getCreatedAt()));
        mrdsPostsThemeVo.setUpdatedAt(ChangeDateUtils.getUnixTransferTime(mrdsPostsTheme.getUpdatedAt()));
        return mrdsPostsThemeVo;
    }
}
