package com.dreamer.education.bean.ro;

import java.io.Serializable;

/**
 * 课程类型响应对象
 * @since 2013-10-25 上午10:23:31
 * @author broken_xie
 */
public class CourseTypeResponse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 6876284612871917591L;
    
    /** 课程类型名称 */
    private String cname;
    
    /** 课程类型代码 */
    private String ccode;
    
    /** 课程类型父级代码 */
    private String cparentcode;
    
    /** 等级【0最高等级】 */
    private Integer ilevel;
    
    /** 父级课程名称 */
    private String cparentname;
    
    /** 父级课程uuid */
    private String uparentid;
    
    /** 主键ID */
    private String uuid;
    
    /**
     * 获取 课程类型名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 课程类型名称
     * @param cname 课程类型名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 课程类型代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 课程类型代码
     * @param ccode 课程类型代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 课程类型父级代码
     * @return cparentcode
     */
    public String getCparentcode() {
        return cparentcode;
    }
    
    /**
     * 设置 课程类型父级代码
     * @param cparentcode 课程类型父级代码
     */
    public void setCparentcode(String cparentcode) {
        this.cparentcode = cparentcode;
    }
    
    /**
     * 获取 等级【0最高等级】
     * @return ilevel
     */
    public Integer getIlevel() {
        return ilevel;
    }
    
    /**
     * 设置 等级【0最高等级】
     * @param ilevel 等级【0最高等级】
     */
    public void setIlevel(Integer ilevel) {
        this.ilevel = ilevel;
    }
    
    /**
     * 获取 父级课程名称
     * @return cparentname
     */
    public String getCparentname() {
        return cparentname;
    }
    
    /**
     * 设置 父级课程名称
     * @param cparentname 父级课程名称
     */
    public void setCparentname(String cparentname) {
        this.cparentname = cparentname;
    }
    
    /**
     * 获取 主键ID
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }
    
    /**
     * 设置 主键ID
     * @param uuid 主键ID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    /**
     * 获取 父级课程uuid
     * @return uparentid
     */
    public String getUparentid() {
        return uparentid;
    }
    
    /**
     * 设置 父级课程uuid
     * @param uparentid 父级课程uuid
     */
    public void setUparentid(String uparentid) {
        this.uparentid = uparentid;
    }
    
}
