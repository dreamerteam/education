package com.dreamer.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.service.TTeacherService;

/**
 * 教师控制器
 * @since 2013-11-7 下午1:47:15
 * @author broken_xie
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController {
    
    /** 教师业务访问接口 */
    @Autowired
    private TTeacherService teacherService;
    
    /**
     * 教师新增
     * @param user 登录信息
     * @param teacher 教师信息
     * @return
     * @author broken_xie
     */
    @RequestMapping("/add")
    public String add(TUser user, TTeacher teacher) {
        teacherService.add(user, teacher, getSessionContainer());
        return SUCCESS;
    }
    
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
        return "main/teacher/list";
    }
    
    /**
     * 查看
     * @param uuid 教师uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(String uuid, Model model) {
        return edit(uuid, model);
    }
    
    /**
     * 修改
     * @param uuid 教师uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/edit")
    public String edit(String uuid, Model model) {
        model.addAttribute("teacher", teacherService.findForView(uuid));
        return mainPage();
    }

    /**
     * 更新教师信息
     * @param teacher 教师信息
     * @param model
     * @author broken_xie
     */
    @RequestMapping("/update")
    public String update(TTeacher teacher, Model model) {
        teacherService.update(teacher, getSessionContainer());
        return SUCCESS;
    }
}
