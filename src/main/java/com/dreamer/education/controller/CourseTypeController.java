package com.dreamer.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.service.TCourseTypeService;

/**
 * 课程类型控制器
 * @since 2013-10-16 下午3:59:13
 * @author broken_xie
 */
@Controller
@RequestMapping("/courseType")
public class CourseTypeController extends BaseController {
    
    /** 课程类型业务访问接口 */
    @Autowired
    private TCourseTypeService courseTypeService;
    
    /**
     * 新增课程类型
     * @param courseType 课程类型
     * @return
     * @author broken_xie
     */
    @RequestMapping("/add")
    public String add(TCourseType courseType) {
        // courseTypeService.add(courseType);
        return null;
    }
    //
    // /**
    // * 校验课程类型
    // * @param courseType 课程类型
    // * @return
    // * @author broken_xie
    // */
    // @RequestMapping("/validate")
    // public String validate(TCourseType courseType) {
    // /* 校验课程类型名称是否已经存在 */
    // Object[][] result = new Object[1][3];
    // result[0][0] = "cname";
    // boolean isCnameExist = courseTypeService.isCnameExist(courseType.getCname());
    // result[0][1] = !isCnameExist;
    // result[0][2] = "* 课程类型名称已存在，请重新填写！";
    // return new Gson().toJson(result);
    // }
}
