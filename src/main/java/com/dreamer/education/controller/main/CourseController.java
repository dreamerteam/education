package com.dreamer.education.controller.main;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.qo.CourseQuery;
import com.dreamer.education.bean.qo.CourseValidate;
import com.dreamer.education.bean.qo.LessionQuery;
import com.dreamer.education.bean.ro.OpenCourseRequest;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TCourseService;
import com.dreamer.education.service.TLessionService;
import com.google.gson.Gson;

/**
 * 课程控制器
 * @since 2013-11-4 上午10:41:06
 * @author broken_xie
 */
@Controller
@RequestMapping("/manage/course")
public class CourseController extends BaseController {
    
    /** 课程业务访问接口 */
    @Autowired
    private TCourseService courseService;
    
    /** 选课业务访问接口 */
    @Autowired
    private TLessionService lessionService;
    
    /**
     * 新增课程
     * @param courseType 课程
     * @return
     * @author broken_xie
     * @throws IOException
     */
    @RequestMapping("/add")
    public String add(TCourse course, MultipartHttpServletRequest request) throws IOException {
        MultipartFile multipartFile = request.getFile("courseImg");
        String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
        String filename = getUUID() + String.valueOf(System.currentTimeMillis());
        File dir = new File(realPath + File.separator + "file/courseImg/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir + File.separator + filename + ".png");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.flush();
        fos.close();
        course.setCpath("/file/courseImg/" + filename + ".png");
        courseService.add(course, getSessionContainer());
        return SUCCESS;
    }
    
    /**
     * 校验课程
     * @param validate 课程校验类
     * @return
     * @author broken_xie
     */
    @RequestMapping("/validate")
    @ResponseBody
    public String validate(CourseValidate validate) {
        /* 校验课程名称是否已经存在 */
        Object[][] result = new Object[1][3];
        boolean isCnameExist = true;
        switch (validate.getCoperate()) {
            case "add":
                result[0][0] = "cname";
                isCnameExist = courseService.isCnameExist(validate.getCname());
                result[0][1] = !isCnameExist;
                if (isCnameExist) {
                    result[0][2] = "* 课程名称已存在，请重新填写！";
                }
                break;
            case "update":
                result[0][0] = "cname";
                if (validate.getColdname().equals(validate.getCname())) {
                    result[0][1] = true;
                } else {
                    isCnameExist = courseService.isCnameExist(validate.getCname());
                    result[0][1] = !isCnameExist;
                    if (isCnameExist) {
                        result[0][2] = "* 课程名称已存在，请重新填写！";
                    }
                }
                break;
            default:
                break;
        }
        return new Gson().toJson(result);
    }
    
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
        return "main/course/list";
    }
    
    /**
     * 获取选课列表
     * @param query 选课查询对象
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/lessionList")
    public String list(LessionQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", lessionService.findPageByQuery(query, currentPage, getSessionContainer()));
        return "main/course/lessionList";
    }
    
    /**
     * 修改
     * @param uuid 课程uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/edit")
    public String edit(String uuid, Model model) {
        model.addAttribute("courseResponse", courseService.findForView(uuid));
        return "/main/course/edit";
    }
    
    /**
     * 查看
     * @param uuid 课程uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(String uuid, Model model) {
        model.addAttribute("courseResponse", courseService.findForView(uuid));
        return "/main/course/view";
    }
    
    /**
     * 更新课程
     * @param course 课程
     * @return
     * @author broken_xie
     */
    @RequestMapping("/update")
    public String update(TCourse course) {
        courseService.update(course, getSessionContainer());
        return SUCCESS;
    }
    
    /**
     * 启用/停用
     * @param uuid 课程uuid
     * @param cstatus 状态【0：停用；1：启用】
     * @return
     * @author broken_xie
     */
    @RequestMapping("/start")
    @ResponseBody
    public Map<String, String> start(String uuid, String cstatus, Model model) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            courseService.start(uuid, cstatus, getSessionContainer());
            map.put("result", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
            map.put("error", "操作失败，请稍后再试");
            return map;
        }
    }
    
    /**
     * 修改课程审核状态
     * @param uuid 课程id
     * @param cstatus 课程审核状态
     * @return
     * @author broken_xie
     */
    @RequestMapping("/changeAudit")
    public String changeAudit(String uuid, String caudit, String preaudit) {
        courseService.changeAudit(uuid, caudit);
        return redirect("/manage/course/list?caudit=" + preaudit);
    }
    
    /**
     * 开课
     * @param openCourse 开课请求对象
     * @return
     * @author broken_xie
     */
    @RequestMapping("/open")
    @ResponseBody
    public Map<String, String> open(OpenCourseRequest openCourse) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            courseService.open(openCourse, getSessionContainer());
            map.put("result", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
            return map;
        }
    }
    
    /**
     * 获取课程图片
     * @param request
     * @return
     * @throws IOException
     * @author broken_xie
     */
    @SuppressWarnings("restriction")
    @RequestMapping("/getImg")
    @ResponseBody
    public String getImg(MultipartHttpServletRequest request) throws IOException {
        MultipartFile multipartFile = request.getFile("courseImg");
        return new sun.misc.BASE64Encoder().encode(multipartFile.getBytes());
    }
}
