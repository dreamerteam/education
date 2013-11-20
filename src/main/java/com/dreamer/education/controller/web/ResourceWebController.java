package com.dreamer.education.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.bean.qo.ResourceQuery;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TResourceService;

/**
 * 资源控制器
 * @since 2013-11-19 上午11:05:21
 * @author broken_xie
 */
@Controller
@RequestMapping("/web/resource")
public class ResourceWebController extends BaseController {
    
    /** 资源业务访问接口 */
    @Autowired
    private TResourceService resourceService;
    
    /**
     * 查看
     * @param uuid 资源uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view/{uuid}")
    public String view(@PathVariable("uuid") String uuid, Model model) {
        model.addAttribute("resource", resourceService.findForView(uuid));
        return "web/resource/view";
    }
    
    /**
     * 获取资源列表
     * @param cname 课程名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/listForFree")
    public String listForFree(ResourceQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        query.setCfree("1");
        model.addAttribute("page", resourceService.findPageByQuery(query, currentPage));
        return "web/resource/list";
    }
}
