package com.dreamer.education.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.service.TUserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
//    
//    /** 用户业务访问接口 */
//    @Autowired
//    private TUserService userService;
//    
//    /**
//     * 登录校验
//     * @param loginReq 登录请求对象
//     * @return
//     * @author broken_xie
//     */
//    @RequestMapping("/validate")
//    @ResponseBody
//    public String validate(LoginRequest loginReq, HttpSession session) {
//        /* 验证码校验 */
//        Object[][] result = new Object[1][3];
//        result[0][0] = "captcha";
//        String captcha = (String) session.getAttribute(loginReq.getCaptchaSessionID());
//        if (null == captcha) {
//            result[0][1] = false;
//            result[0][2] = "* 请重新刷新验证码";
//            return new Gson().toJson(result);
//        }
//        boolean isCaptcha = captcha.equals(loginReq.getCaptcha()); // 验证码是否正确【true：正确；false：错误】
//        result[0][1] = isCaptcha;
//        if (!isCaptcha) {
//            result[0][2] = "* 验证码错误";
//            return new Gson().toJson(result);
//        }
//        /* 登录名校验 */
//        result[0][0] = "clogin";
//        TUser user = userService.findByClogin(loginReq.getClogin());
//        if (null == user) {
//            result[0][1] = false;
//            result[0][2] = "* 用户名不存在";
//            return new Gson().toJson(result);
//        }
//        /* 登录密码校验 */
//        result[0][0] = "cpassword";
//        if (!user.getCpassword().equals(MD5(loginReq.getCpassword()))) {
//            result[0][1] = false;
//            result[0][2] = "* 密码错误";
//            return new Gson().toJson(result);
//        }
//        result[0][1] = true;
//        return new Gson().toJson(result);
//    }
}
