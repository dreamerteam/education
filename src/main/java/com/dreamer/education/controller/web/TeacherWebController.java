package com.dreamer.education.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TTeacherService;

/**
 * 教师控制器
 * @since 2013-11-19 上午11:55:49
 * @author broken_xie
 */
@Controller
@RequestMapping("/web/teacher")
public class TeacherWebController extends BaseController {
    
    /** 教师业务访问接口 */
    @Autowired
    private TTeacherService teacherService;
    
    /**
     * 获取教师信息列表
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", teacherService.findPageByQuery(currentPage));
        return "web/teacher/list";
    }

    /**
     * 查看
     * @param uuid 教师uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view/{uuid}")
    public String view(@PathVariable("uuid") String uuid, Model model) {
        model.addAttribute("teacher", teacherService.findForView(uuid));
        return "web/teacher/view";
    }
}
