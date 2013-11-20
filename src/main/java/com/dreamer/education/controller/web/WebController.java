package com.dreamer.education.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TCourseService;
import com.dreamer.education.service.TResourceService;
import com.dreamer.education.service.TTeacherService;

/**
 * 网站前台控制器
 * @since 2013-11-7 下午1:10:28
 * @author broken_xie
 */
@Controller
@RequestMapping("/web")
public class WebController extends BaseController {
    
    /** 课程业务访问接口 */
    @Autowired
    private TCourseService courseService;
    
    /** 教师业务访问接口 */
    @Autowired
    private TTeacherService teacherService;
    
    /** 资源业务访问接口 */
    @Autowired
    private TResourceService resourceService;
    
    /**
     * 网站展示首页
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("courses", courseService.findForHot());
        model.addAttribute("teachers", teacherService.findForHot());
        model.addAttribute("resources", resourceService.findForFree());
        return "/web/index";
    }
}
