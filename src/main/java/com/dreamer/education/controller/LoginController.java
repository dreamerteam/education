package com.dreamer.education.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.bean.ro.LoginRequest;
import com.dreamer.education.service.TManagerService;
import com.dreamer.education.service.TStudentService;
import com.dreamer.education.service.TTeacherService;
import com.dreamer.education.service.TUserService;
import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;

@Controller
@RequestMapping("/manage")
public class LoginController extends BaseController {
    
    /** 用户业务访问接口 */
    @Autowired
    private TUserService userService;
    
    /** 管理员业务访问接口 */
    @Autowired
    private TManagerService managerService;
    
    /** 教师业务访问接口 */
    @Autowired
    private TTeacherService teacherService;
    
    /** 学生业务访问接口 */
    @Autowired
    private TStudentService studentService;
    
    /**
     * 用户登录
     * @param loginReq 登录请求对象
     * @param session
     * @param model
     * @param response
     * @return
     * @author broken_xie
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(LoginRequest loginReq, HttpSession session, Model model, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            SessionContainer sessionContainer = new SessionContainer();
            TUser user = userService.findByClogin(loginReq.getClogin());
            String authrity = user.getCtype();
            switch (authrity) {
                case "manager":
                    sessionContainer.setManager(managerService.findByUuid(user.getUpersonid()));
                    break;
                case "teacher":
                    sessionContainer.setTeacher(teacherService.findByUuid(user.getUpersonid()));
                    break;
                case "student":
                    sessionContainer.setStudent(studentService.findByUuid(user.getUpersonid()));
                    break;
                default:
                    break;
            }
            sessionContainer.setUser(user);
            sessionContainer.setAuthority(authrity);
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
     * 退出登录
     * @return
     * @author broken_xie
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout() {
        getSession().invalidate();
        return null;
    }
    
    /**
     * 获取Cookie
     * @param request
     * @return
     * @author broken_xie
     */
    @RequestMapping("/login/getCookies")
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
     * 登录校验
     * @param loginReq 登录请求对象
     * @return
     * @author broken_xie
     */
    @RequestMapping("/login/validate")
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
}
