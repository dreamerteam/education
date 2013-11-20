package com.dreamer.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.service.TStudentService;

/**
 * 学生控制器
 * @since 2013-11-13 下午2:39:42
 * @author broken_xie
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    
    /** 学生信息业务访问接口 */
    @Autowired
    private TStudentService studentService;
    
    /**
     * 获取学生信息列表
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", studentService.findPageByQuery(currentPage));
        return "main/student/list";
    }
    
    /**
     * 查看
     * @param uuid 学生uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(String uuid, Model model) {
        model.addAttribute("student", studentService.findForView(uuid));
        return mainPage();
    }
}
