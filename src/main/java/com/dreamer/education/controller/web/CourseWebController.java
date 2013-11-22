package com.dreamer.education.controller.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.qo.CourseQuery;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TCourseFavoriteService;
import com.dreamer.education.service.TCourseService;
import com.dreamer.education.service.TLessionService;

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
    
    /** 课程收藏业务访问接口 */
    @Autowired
    private TCourseFavoriteService courseFavoriteService;
    
    /** 选课业务访问接口 */
    @Autowired
    private TLessionService lessionService;
    
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
    
    /**
     * 查看
     * @param uuid 课程uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view/{uuid}")
    public String view(@PathVariable("uuid") String uuid, Model model) {
        model.addAttribute("course", courseService.findForView(uuid));
        return "web/course/view";
    }
    
    /**
     * 收藏课程
     * @param ucourseid 课程id
     * @return
     * @author broken_xie
     */
    @RequestMapping("/collect")
    @ResponseBody
    public Map<String, Object> collect(String ucourseid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return courseFavoriteService.collect(ucourseid, getSessionContainer());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
            map.put("error", "操作失败，请稍后再试");
            return map;
        }
    }
    
    /**
     * 上课
     * @param ucourseid 课程id
     * @return
     * @author broken_xie
     */
    @RequestMapping("/select")
    @ResponseBody
    public Map<String, Object> select(String ucourseid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            lessionService.select(ucourseid, getSessionContainer());
            map.put("result", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
            map.put("error", "操作失败，请稍后再试");
            return map;
        }
    }
}
