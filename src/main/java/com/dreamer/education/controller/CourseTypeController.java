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
import com.dreamer.education.bean.qo.CourseTypeVlidate;
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
    	System.out.println("asfaasfasdaasf==="+cparentcode);
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
    public String validate(CourseTypeVlidate validate) {
        /* 校验课程类型名称是否已经存在 */
        Object[][] result = new Object[2][3];
        result[0][0] = "cname";
        switch (validate.getCoperate()) {
            case "add":
                result[0][0] = "cname";
                boolean isCnameExist = courseTypeService.isCnameExist(validate.getCname());
                result[0][1] = !isCnameExist;
                if (isCnameExist) result[0][2] = "* 课程类型名称已存在，请重新填写！";
                if (isEmpty(validate.getUparentid())) { // 顶级课程类型需要判断代码唯一性，其他不需要判断
                    result[1][0] = "ccode";
                    boolean isCcodeExist = courseTypeService.isCcodeExist((validate.getCcode() + "|").toUpperCase());
                    result[1][1] = !isCcodeExist;
                    if (isCcodeExist) result[1][2] = "* 课程类型代码已存在，请重新填写！";
                }
                break;
            case "update":
                result[0][0] = "cname";
                if (validate.getColdname().equals(validate.getCname())) {
                    result[0][1] = true;
                } else {
                    isCnameExist = courseTypeService.isCnameExist(validate.getCname());
                    result[0][1] = !isCnameExist;
                    if (isCnameExist) result[0][2] = "* 课程类型名称已存在，请重新填写！";
                }
                if (isEmpty(validate.getUparentid())) { // 顶级课程类型需要判断代码唯一性，其他不需要判断
                    if (validate.getColdcode().equals(validate.getCcode())) {
                        result[1][1] = true;
                    } else {
                        result[1][0] = "ccode";
                        boolean isCcodeExist = courseTypeService.isCcodeExist((validate.getCcode() + "|").toUpperCase());
                        result[1][1] = !isCcodeExist;
                        if (isCcodeExist) result[1][2] = "* 课程类型代码已存在，请重新填写！";
                    }
                }
                break;
            default:
                break;
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
        return "main/courseType/list";
    }
    
    /**
     * 修改
     * @param uuid 课程类型uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/edit")
    public String edit(String uuid, Model model) {
        model.addAttribute("courseTypeResponse", courseTypeService.findForView(uuid));
        return mainPage();
    }
    
    /**
     * 查看
     * @param uuid 课程类型uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(String uuid, Model model) {
        return edit(uuid, model);
    }
    
    /**
     * 删除
     * @param uuid 课程类型uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/del")
    public String del(String ccode, Model model) {
        courseTypeService.delete(ccode);
        return list(null, 1, model);
    }
    
    /**
     * 更新课程类型
     * @param courseType 课程类型
     * @param cparentcode 父级课程类型代码
     * @return
     * @author broken_xie
     */
    @RequestMapping("/update")
    public String update(TCourseType courseType, String cparentcode) {
        if (!isUUID(courseType.getUparentid())) {
            courseType.setUparentid(null);
            courseType.setCcode((courseType.getCcode() + "|").toUpperCase());
        } else {
            courseType.setCcode((cparentcode + courseType.getCcode() + "|").toUpperCase());
        }
        courseTypeService.update(courseType);
        return SUCCESS;
    }
    
}
