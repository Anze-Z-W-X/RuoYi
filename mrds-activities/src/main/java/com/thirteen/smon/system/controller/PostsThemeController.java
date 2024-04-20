//package com.thirteen.smon.system.controller;
//
//import com.ruoyi.common.annotation.Log;
//import com.ruoyi.common.core.controller.BaseController;
//import com.ruoyi.common.core.domain.AjaxResult;
//import com.ruoyi.common.core.page.TableDataInfo;
//import com.ruoyi.common.enums.BusinessType;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.thirteen.smon.system.domain.entity.PostsTheme;
//import com.thirteen.smon.system.service.PostsThemeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@RestController
//@RequestMapping("/mrds/postTheme")
//public class PostsThemeController extends BaseController {
//    @Autowired
//    private PostsThemeService postsThemeService;
//
//    @PreAuthorize("@ss.hasPermi('mrds:postTheme:list')")
//    @GetMapping("/list")
//    public TableDataInfo getPostsList(){   //TODO 模糊查询@RequestBody PostsTheme postsTheme
//        return getDataTable(postsThemeService.getPostsList());
//    }
//
//    /**
//     * 导出活动管理列表
//     */
//    @PreAuthorize("@ss.hasPermi('mrds:postTheme:export')")
//    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, PostsTheme PostsTheme)
//    {
//        List<PostsTheme> list = postsThemeService.selectPostsThemeList(PostsTheme);
//        ExcelUtil<PostsTheme> util = new ExcelUtil<PostsTheme>(PostsTheme.class);
//        util.exportExcel(response, list, "活动管理数据");
//    }
//
//    /**
//     * 获取活动管理详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('mrds:postTheme:query')")
//    @GetMapping( "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Long id)
//    {
//        return success(postsThemeService.selectPostsThemeById(id));
//    }
//
//    @PreAuthorize("@ss.hasPermi('mrds:postTheme:add')")
//    @Log(title = "活动管理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult addPostsTheme(@RequestBody PostsTheme postsTheme){
//        return toAjax(postsThemeService.addPostsTheme(postsTheme));
//    }
//
//    @PutMapping()
//    public AjaxResult updatePostsTheme(@RequestBody PostsTheme postsTheme){
//        return toAjax(postsThemeService.updatePostsTheme(postsTheme));
//    }
//
//    @DeleteMapping("/{ids}")
//    public AjaxResult deletePostsTheme(@PathVariable Long[] ids){
//        return toAjax(postsThemeService.deletePostsTheme(ids));
//    }
//}
