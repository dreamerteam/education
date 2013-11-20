package com.dreamer.education.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.bean.qo.CourseQuery;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TCourseService;

/**
 * 课程控制器
 * @since 2013-11-19 上午11:49:40
 * @author broken_xie
 */
@Controller
@RequestMapping("/web/course")
public class CourseWebController extends BaseController {
    
    /** 课程业务访问接口 */
    @Autowired
    private TCourseService courseService;
    
    /**
     * 获取课程列表
     * @param cname 课程名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(CourseQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", courseService.findPageByQuery(query, currentPage));
        return "web/course/list";
    }
}
