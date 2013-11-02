package com.dreamer.education.bean.ro;

import static com.dreamer.education.utils.StringUtils.defaultString;

import java.io.Serializable;

/**
 * 登录请求对象
 * @since 2013-10-6 下午3:25:25
 * @author broken_xie
 */
public class LoginRequest implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 4231157448476614888L;
    
    /** 登录名 */
    private String clogin;
    
    /** 密码 */
    private String cpassword;
    
    /** 验证码 */
    private String captcha;
    
    /** 是否保存用户名【0：不保存；1：保存】 */
    private String remember;
    
    /**
     * 获取 登录名
     * @return clogin
     */
    public String getClogin() {
        return clogin;
    }
    
    /**
     * 设置 登录名
     * @param clogin 登录名
     */
    public void setClogin(String clogin) {
        this.clogin = defaultString(clogin);
    }
    
    /**
     * 获取 密码
     * @return cpassword
     */
    public String getCpassword() {
        return cpassword;
    }
    
    /**
     * 设置 密码
     * @param cpassword 密码
     */
    public void setCpassword(String cpassword) {
        this.cpassword = defaultString(cpassword);
    }
    
    /**
     * 获取 验证码
     * @return captcha
     */
    public String getCaptcha() {
        return captcha;
    }
    
    /**
     * 设置 验证码
     * @param captcha 验证码
     */
    public void setCaptcha(String captcha) {
        this.captcha = defaultString(captcha);
    }
    
    /**
     * 获取 是否保存用户名【0：不保存；1：保存】
     * @return remember
     */
    public String getRemember() {
        return remember;
    }
    
    /**
     * 设置 是否保存用户名【0：不保存；1：保存】
     * @param remember 是否保存用户名【0：不保存；1：保存】
     */
    public void setRemember(String remember) {
        this.remember = remember;
    }
    
}
