package com.dreamer.education.controller;

import static com.dreamer.education.utils.ValidateUtils.isEmpty;
import static com.dreamer.education.utils.ValidateUtils.isUUID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.qo.CourseTypeVlidate;
import com.dreamer.education.bean.qo.CourseValidate;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.bean.ro.CourseTypeResponse;
import com.dreamer.education.dao.TCourseTypeDao;
import com.dreamer.education.service.TCourseService;
import com.dreamer.education.service.TCourseTypeService;
import com.google.gson.Gson;


/*
* @author Owen
* @version 创建时间：2013年10月28日 下午3:14:29 
*/ 
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {
	@Autowired
	private TCourseService courseService;
	    
	@Autowired
	private TCourseTypeDao courseTypeDao;
	
	@RequestMapping("/add")
	public String add(TCourse course, String utypename) {
		List<TCourseType> courseType=courseTypeDao.findByCname(utypename);
		course.setUtypeid(courseType.get(0).getUuid());
	        courseService.add(course);
	        return SUCCESS;
	    }
	
	@RequestMapping("/validate")
    @ResponseBody
    public String validate(CourseValidate validate) {
        /* 校验课程类型名称是否已经存在 */
        Object[][] result = new Object[2][3];
        result[0][0] = "cname";
        switch (validate.getCoperate()) {
            case "add":
                result[0][0] = "cname";
                boolean isCnameExist = courseService.isCnameExist(validate.getCname());
                result[0][1] = !isCnameExist;
                if (isCnameExist) result[0][2] = "* 课程类型名称已存在，请重新填写！";
                break;
            case "update":
                result[0][0] = "cname";
                if (validate.getColdname().equals(validate.getCname())) {
                    result[0][1] = true;
                } else {
                    isCnameExist = courseService.isCnameExist(validate.getCname());
                    result[0][1] = !isCnameExist;
                    if (isCnameExist) result[0][2] = "* 课程类型名称已存在，请重新填写！";
                }
                break;
            default:
                break;
        }
        return new Gson().toJson(result);
    }
    
	@RequestMapping("/list")
    public String list(String cname, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", courseService.findPageByQuery(cname, currentPage));
        return "main/course/list";
    }
    
	@RequestMapping("/edit")
	public String edit(String uuid, Model model) {
	    model.addAttribute("courseResponse", courseService.findForView(uuid));
	    return mainPage();
	    }
	
	@RequestMapping("/view")
    public String view(String uuid, Model model) {
        return edit(uuid, model);
    }
    
	 @RequestMapping("/del")
	 public String del(String uuid, Model model) {
		 courseService.delete(uuid);
		 return list(null, 1, model);
	}

	@RequestMapping("/update")
	public String update(CourseResponse course) {
		courseService.update(course);
		return SUCCESS;
	}
}
