package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 课程查询对象
 * @since 2013-11-14 下午3:43:15
 * @author broken_xie
 */
public class CourseQuery implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 8485510873188636506L;
    
    /** 课程名称 */
    private String cname;
    
    /** 课程状态 */
    private String caudit;
    
    /**
     * 获取 课程名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 课程名称
     * @param cname 课程名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 课程状态
     * @return caudit
     */
    public String getCaudit() {
        return caudit;
    }
    
    /**
     * 设置 课程状态
     * @param caudit 课程状态
     */
    public void setCaudit(String caudit) {
        this.caudit = caudit;
    }
    
}
