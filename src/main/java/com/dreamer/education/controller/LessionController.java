package com.dreamer.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dreamer.education.bean.qo.LessionQuery;
import com.dreamer.education.service.TLessionService;

/**
 * 选课控制器
 * @since 2013-11-19 下午1:49:31
 * @author broken_xie
 */
@Controller
@RequestMapping("/manage/lession")
public class LessionController extends BaseController {
    
    /** 选课业务访问接口 */
    @Autowired
    private TLessionService lessionService;
    
    /**
     * 获取选课列表
     * @param query 课程名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(LessionQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", lessionService.findPageByQuery(query, currentPage));
        return "main/lession/list";
    }
    
    /**
     * 获取待开课列表
     * @param query 课程名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/listNOpen")
    public String listNOpen(LessionQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", lessionService.findPageByQuery(query, currentPage));
        return "main/lession/list";
    }
}
