package com.dreamer.education.controller.web;

import static com.dreamer.education.utils.Encryption.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.bean.qo.LessionQuery;
import com.dreamer.education.bean.ro.LoginRequest;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.TCourseFavoriteService;
import com.dreamer.education.service.TLessionService;
import com.dreamer.education.service.TStudentService;
import com.dreamer.education.service.TUserService;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

/**
 * 学生控制器
 * @since 2013-11-4 下午9:29:37
 * @author broken_xie
 */
@Controller
public class StudentWebController extends BaseController {
    
    /** 用户业务访问接口 */
    @Autowired
    private TUserService userService;
    
    /** 学生业务访问接口 */
    @Autowired
    private TStudentService studentService;
    
    /** 课程收藏业务访问接口 */
    @Autowired
    private TCourseFavoriteService courseFavoriteService;
    
    /** 选课业务访问接口 */
    @Autowired
    private TLessionService lessionService;
    
    /**
     * 校验学生注册信息
     * @param clogin 登录名
     * @return
     * @author broken_xie
     */
    @RequestMapping("/student/validate")
    @ResponseBody
    public String validate(String clogin) {
        Object[][] result = new Object[1][3];
        result[0][0] = "clogin";
        boolean isCloginExist = userService.isCloginExist(clogin);
        result[0][1] = !isCloginExist;
        if (isCloginExist) {
            result[0][2] = "* 登录名已存在，请重新填写！";
        }
        return new Gson().toJson(result);
    }
    
    /**
     * 学生注册
     * @return
     * @author broken_xie
     */
    @RequestMapping("/student/register")
    public String register(TUser user) {
        userService.register(user, "student", getSessionContainer());
        return "/web/student/personal/index";
    }
    
    /**
     * 登录校验
     * @param loginReq 登录请求对象
     * @return
     * @author broken_xie
     */
    @RequestMapping("/student/login/validate")
    @ResponseBody
    public String validate(LoginRequest loginReq, HttpSession session) {
        /* 验证码校验 */
        Object[][] result = new Object[1][3];
        result[0][0] = "captcha";
        String captcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (null == captcha) {
            result[0][1] = false;
            result[0][2] = "* 请重新刷新验证码";
            return new Gson().toJson(result);
        }
        boolean isCaptcha = captcha.equals(loginReq.getCaptcha()); // 验证码是否正确【true：正确；false：错误】
        result[0][1] = isCaptcha;
        if (!isCaptcha) {
            result[0][2] = "* 验证码错误";
            return new Gson().toJson(result);
        }
        /* 登录名校验 */
        result[0][0] = "clogin";
        TUser user = userService.findByClogin(loginReq.getClogin());
        if (null == user) {
            result[0][1] = false;
            result[0][2] = "* 用户名不存在";
            return new Gson().toJson(result);
        } else if (!"student".equals(user.getCtype())) {
            result[0][1] = false;
            result[0][2] = "* 用户名不存在";
            return new Gson().toJson(result);
        }
        /* 登录密码校验 */
        result[0][0] = "cpassword";
        if (!user.getCpassword().equals(MD5(loginReq.getCpassword()))) {
            result[0][1] = false;
            result[0][2] = "* 密码错误";
            return new Gson().toJson(result);
        }
        result[0][1] = true;
        return new Gson().toJson(result);
    }
    
    /**
     * 获取Cookie
     * @param request
     * @return
     * @author broken_xie
     */
    @RequestMapping("/student/login/getCookies")
    @ResponseBody
    public Map<String, Object> getCookies(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            try {
                map.put(cookie.getName(), URLDecoder.decode(cookie.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error("Cookie获取错误", e);
            }
        }
        return map;
    }
    
    /**
     * 用户登录
     * @param loginReq 登录请求对象
     * @param session
     * @param model
     * @param response
     * @return
     * @author broken_xie
     */
    @RequestMapping("/student/login")
    @ResponseBody
    public Map<String, Object> login(LoginRequest loginReq, HttpSession session, Model model, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            SessionContainer sessionContainer = new SessionContainer();
            TUser user = userService.findByClogin(loginReq.getClogin());
            sessionContainer.setStudent(studentService.findByUuid(user.getUpersonid()));
            sessionContainer.setUser(user);
            sessionContainer.setAuthority(user.getCtype());
            session.setAttribute(SESSION_CONTAINER_KEY, sessionContainer);
            if ("1".equals(loginReq.getRemember())) {
                Cookie loginCookie = new Cookie("clogin", URLEncoder.encode(loginReq.getClogin().toString(), "UTF-8"));
                Cookie rememberCookie = new Cookie("remember", "1");
                int age = 7 * 24 * 60 * 60; // 保存一周
                loginCookie.setMaxAge(age);
                rememberCookie.setMaxAge(age);
                response.addCookie(loginCookie);
                response.addCookie(rememberCookie);
            } else {
                Cookie loginCookie = new Cookie("clogin", null);
                Cookie rememberCookie = new Cookie("remember", null);
                int age = 0; // 不保存
                loginCookie.setMaxAge(age);
                rememberCookie.setMaxAge(age);
                response.addCookie(loginCookie);
                response.addCookie(rememberCookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            map.put("result", "failure");
            map.put("error", "登录失败，请稍后再试！");
            return map;
        }
        map.put("result", "success");
        return map;
    }
    
    /**
     * 查看个人信息
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/web/student/personal/view")
    public String view(Model model) {
        getPersonalInfo(model);
        return requestPage();
    }
    
    /**
     * 完善个人信息
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/web/student/personal/perfect")
    public String perfect(Model model) {
        getPersonalInfo(model);
        return requestPage();
    }
    
    /**
     * 获取个人信息
     * @param model
     * @author broken_xie
     */
    private void getPersonalInfo(Model model) {
        model.addAttribute("user", getSessionContainer().getUser());
        model.addAttribute("student", getSessionContainer().getStudent());
    }
    
    /**
     * 更新个人信息
     * @param student 学生信息
     * @param model
     * @author broken_xie
     */
    @RequestMapping("/web/student/personal/update")
    public String update(TStudent student, Model model) {
        TStudent s = studentService.update(student, getSessionContainer());
        SessionContainer sessionContainer = getSessionContainer();
        sessionContainer.setStudent(s);
        getPersonalInfo(model);
        return "/web/student/personal/view";
    }
    
    /**
     * 查找课程收藏列表
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/web/student/course/favoriteList")
    public String favoriteList(@RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", courseFavoriteService.findPageByQuery(currentPage, getSessionContainer()));
        return "/web/student/course/favoriteList";
    }
    
    /**
     * 获取选课列表
     * @param query 课程名称
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/web/student/course/lessionList")
    public String list(LessionQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", lessionService.findPageByQuery(query, currentPage, getSessionContainer()));
        return "/web/student/course/lessionList";
    }
    
}
