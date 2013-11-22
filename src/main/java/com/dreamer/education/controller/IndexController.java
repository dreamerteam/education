package com.dreamer.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理控制器
 * @since 2013-11-21 上午11:01:10
 * @author broken_xie
 */
@Controller
public class IndexController extends BaseController {
    
    /**
     * 跳转到后台管理页面
     * @return
     * @author broken_xie
     */
    @RequestMapping("/manage")
    public String toManage() {
        return "/main/index";
    }
    
    /**
     * 跳转到后台管理登陆页面
     * @return
     * @author broken_xie
     */
    @RequestMapping("/manage/login")
    public String toLogin() {
        return "/main/login";
    }
}
