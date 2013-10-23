package com.dreamer.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.service.AutoCompleteService;

/**
 * 数据下拉 控制器
 * @since 2013-10-17 下午12:00:18
 * @author broken_xie
 */
@Controller
@RequestMapping("/autoComplete")
public class AutoCompleteController extends BaseController {
    
    /** 数据下拉 业务访问接口 */
    @Autowired
    private AutoCompleteService autoCompleteService;
    
    /**
     * 根据数据类型获取相关数据
     * @param type 获取的数据类型
     * @return
     * @author broken_xie
     */
    @RequestMapping("/{type}")
    @ResponseBody
    public String getData(@PathVariable("type") String type) {
        return autoCompleteService.getData(type);
    }
}
