package com.ruoyi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.domain.vo.MrdsPostsThemeVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.domain.entity.MrdsPostsTheme;
import com.ruoyi.service.IMrdsPostsThemeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动管理Controller
 *
 * @author Anze_xuu
 * @date 2024-04-19
 */
@RestController
@RequestMapping("/mrds/postTheme")
public class MrdsPostsThemeController extends BaseController
{
    @Autowired
    private IMrdsPostsThemeService mrdsPostsThemeService;

    /**
     * 查询活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:list')")
    @GetMapping("/list")
    public TableDataInfo list(MrdsPostsTheme mrdsPostsTheme)
    {
        startPage();
        List<MrdsPostsThemeVo> list = mrdsPostsThemeService.selectMrdsPostsThemeList(mrdsPostsTheme);
        return getDataTable(list);
    }

    /**
     * 导出活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:export')")
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MrdsPostsTheme mrdsPostsTheme)
    {
        List<MrdsPostsThemeVo> list = mrdsPostsThemeService.selectMrdsPostsThemeList(mrdsPostsTheme);
        ExcelUtil<MrdsPostsThemeVo> util = new ExcelUtil<MrdsPostsThemeVo>(MrdsPostsThemeVo.class);
        util.exportExcel(response, list, "活动管理数据");
    }

    /**
     * 获取活动管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getPostThemeById(@PathVariable("id") Long id)
    {
        return success(mrdsPostsThemeService.selectMrdsPostsThemeById(id));
    }

    /**
     * 新增活动管理
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:add')")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult addPostTheme(@RequestBody MrdsPostsTheme mrdsPostsTheme)
    {
        return toAjax(mrdsPostsThemeService.insertMrdsPostsTheme(mrdsPostsTheme));
    }

    /**
     * 修改活动管理
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:edit')")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult updatePostTheme(@RequestBody MrdsPostsTheme mrdsPostsTheme)
    {
        return toAjax(mrdsPostsThemeService.updateMrdsPostsTheme(mrdsPostsTheme));
    }

    /**
     * 删除活动管理
     */
    @PreAuthorize("@ss.hasPermi('mrds:postTheme:remove')")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult delPostTheme(@PathVariable Long[] ids)    //逻辑删除
    {
        return toAjax(mrdsPostsThemeService.deleteMrdsPostsThemeByIds(ids));
    }
}
