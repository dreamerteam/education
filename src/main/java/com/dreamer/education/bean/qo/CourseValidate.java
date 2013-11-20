package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 课程校验类
 * @since 2013-10-25 上午11:51:41
 * @author broken_xie
 */
public class CourseValidate implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -6213091968884077895L;
    
    /** 名称 */
    private String cname;
    
    /** 操作类型【add：添加；update：修改】 */
    private String coperate;
    
    /** 修改前的名称 */
    private String coldname;
    
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
    
}
