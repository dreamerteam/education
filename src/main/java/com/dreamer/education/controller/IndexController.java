package com.dreamer.education.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    /**
     * 跳转到后台管理登陆页面
     * @return
     * @author broken_xie
     */
    @RequestMapping("/manage")
    public String toManage() {
        return "/main/index";
    }
}
