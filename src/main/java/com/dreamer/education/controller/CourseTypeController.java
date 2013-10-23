package com.dreamer.education.controller;

import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.service.TCourseTypeService;
import com.google.gson.Gson;

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
     * @param cparentcode 父级课程类型代码
     * @return
     * @author broken_xie
     */
    @RequestMapping("/add")
    public String add(TCourseType courseType, String cparentcode) {
        courseType.setCcode((isEmpty(cparentcode) ? courseType.getCcode() + "|" : cparentcode + courseType.getCcode() + "|").toUpperCase());
        courseTypeService.add(courseType);
        return SUCCESS;
    }
    
    /**
     * 校验课程类型
     * @param courseType 课程类型
     * @return
     * @author broken_xie
     */
    @RequestMapping("/validate")
    @ResponseBody
    public String validate(TCourseType courseType) {
        /* 校验课程类型名称是否已经存在 */
        Object[][] result = new Object[2][3];
        result[0][0] = "cname";
        boolean isCnameExist = courseTypeService.isCnameExist(courseType.getCname());
        result[0][1] = !isCnameExist;
        if (isCnameExist) result[0][2] = "* 课程类型名称已存在，请重新填写！";
        if (isEmpty(courseType.getUparentid())) { // 顶级课程类型需要判断代码唯一性，其他不需要判断
            result[0][0] = "ccode";
            boolean isCcodeExist = courseTypeService.isCcodeExist((courseType.getCcode() + "|").toUpperCase());
            result[0][1] = !isCcodeExist;
            if (isCcodeExist) result[0][2] = "* 课程类型代码已存在，请重新填写！";
        }
        return new Gson().toJson(result);
    }
}
