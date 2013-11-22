package com.dreamer.education.controller;

import static com.dreamer.education.utils.DateUtils.dateTimeString;
import static com.dreamer.education.utils.DateUtils.toDate;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.utils.InitParam;

/**
 * 控制器基类
 * @since 2013-10-5 下午4:44:37
 * @author broken_xie
 */
public class BaseController {
    
    /** 日志 */
    protected Logger logger = Logger.getLogger(this.getClass());
    
    /** 跳转成功页面 */
    protected static final String SUCCESS = "common/success";
    
    /** 会话容器id */
    protected static final String SESSION_CONTAINER_KEY = InitParam.getValue("sessionContainerKey");
    
    /**
     * 返回main目录下的jsp页面
     * @return
     * @author broken_xie
     */
    protected String mainPage() {
        return "main/" + requestPage();
    }
    
    /**
     * 返回web目录下的jsp页面
     * @return
     * @author broken_xie
     */
    protected String webPage() {
        return "web/" + requestPage();
    }
    
    /**
     * 请求jsp页面
     * @return
     * @author broken_xie
     */
    protected String requestPage() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getRequestURI().substring(request.getContextPath().length() + 1);
    }
    
    /**
     * 获取HttpServletRequest请求对象
     * @return
     * @author broken_xie
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    /**
     * 获取HttpSession会话对象
     * @return
     * @author broken_xie
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }
    
    /**
     * 根据cookie名称获取cookie
     * @param cookieName cookie名称
     * @return
     * @author broken_xie
     */
    protected String getCookie(String cookieName) {
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) return cookie.getValue();
        }
        return null;
    }
    
    /**
     * 获取 会话容器
     * @return sessionContainerKey
     */
    protected SessionContainer getSessionContainer() {
        return (SessionContainer) getSession().getAttribute(SESSION_CONTAINER_KEY);
    }
    
    /**
     * 重定向到指定的地址
     * @param url 地址
     * @return
     * @author broken_xie
     */
    protected String redirect(String url) {
        return "redirect:" + url;
    }
    
    /**
     * 日期解析
     * @param binder
     * @author broken_xie
     */
    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
            public void setAsText(String value) {
                setValue(toDate(value));
            }
            
            public String getAsText() {
                return dateTimeString((Date) getValue());
            }
            
        });
    }
    
}
