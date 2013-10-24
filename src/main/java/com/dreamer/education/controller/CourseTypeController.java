package com.dreamer.education.controller;

import static com.dreamer.education.utils.ValidateUtils.isEmpty;
import static com.dreamer.education.utils.ValidateUtils.isUUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        if (!isUUID(courseType.getUparentid())) {
            courseType.setUparentid(null);
            courseType.setCcode((courseType.getCcode() + "|").toUpperCase());
        } else {
            courseType.setCcode((cparentcode + courseType.getCcode() + "|").toUpperCase());
        }
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
            result[1][0] = "ccode";
            boolean isCcodeExist = courseTypeService.isCcodeExist((courseType.getCcode() + "|").toUpperCase());
            result[1][1] = !isCcodeExist;
            if (isCcodeExist) result[1][2] = "* 课程类型代码已存在，请重新填写！";
        }
        return new Gson().toJson(result);
    }
    
    /**
     * 获取课程类型列表
     * @param cname 课程类型名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(String cname, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", courseTypeService.findPageByQuery(cname, currentPage));
        return mainPage();
    }
    
    /**
     * 修改
     * @param uuid 课程类型uuid
     * @param model
     * @return
     * @author broken_xie
     */
    public String edit(String uuid, Model model) {
        model.addAttribute("courseType", courseTypeService.findByUuid(uuid));
        return mainPage();
    }
    
}
