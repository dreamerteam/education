package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 课程类型校验类
 * @since 2013-10-25 上午11:51:41
 * @author broken_xie
 */
public class CourseTypeVlidate implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 4539524189640414063L;
    
    /** 名称 */
    private String cname;
    
    /** 代码 */
    private String ccode;
    
    /** 父级uuid */
    private String uparentid;
    
    /** 操作类型【add：添加；update：修改】 */
    private String coperate;
    
    /** 修改前的名称 */
    private String coldname;
    
    /** 修改前的代码 */
    private String coldcode;
    
    /**
     * 获取 名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 名称
     * @param cname 名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 代码
     * @param ccode 代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 操作类型【add：添加；update：修改】
     * @return coperate
     */
    public String getCoperate() {
        return coperate;
    }
    
    /**
     * 设置 操作类型【add：添加；update：修改】
     * @param coperate 操作类型【add：添加；update：修改】
     */
    public void setCoperate(String coperate) {
        this.coperate = coperate;
    }
    
    /**
     * 获取 修改前的名称
     * @return coldname
     */
    public String getColdname() {
        return coldname;
    }
    
    /**
     * 设置 修改前的名称
     * @param coldname 修改前的名称
     */
    public void setColdname(String coldname) {
        this.coldname = coldname;
    }
    
    /**
     * 获取 修改前的代码
     * @return coldcode
     */
    public String getColdcode() {
        return coldcode;
    }
    
    /**
     * 设置 修改前的代码
     * @param coldcode 修改前的代码
     */
    public void setColdcode(String coldcode) {
        this.coldcode = coldcode;
    }
    
    /**
     * 获取 父级uuid
     * @return uparentid
     */
    public String getUparentid() {
        return uparentid;
    }
    
    /**
     * 设置 父级uuid
     * @param uparentid 父级uuid
     */
    public void setUparentid(String uparentid) {
        this.uparentid = uparentid;
    }
    
}
