package com.dreamer.education.bean.ro;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师信息响应对象
 * @since 2013-11-13 下午1:39:10
 * @author broken_xie
 */
public class StudentResponse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 9080901991721534579L;
    
    /** 主键ID */
    private String uuid;
    
    /** 国籍 */
    private String ccountry;
    
    /** 学历 */
    private String ceducation;
    
    /** 手机号 */
    private String cmobile;
    
    /** 姓名 */
    private String cname;
    
    /** 编号 */
    private String cno;
    
    /** QQ号 */
    private String cqq;
    
    /** 性别【男；女】 */
    private String csex;
    
    /** 更新日期 */
    private Date dupdate;
    
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
     * 获取 国籍
     * @return ccountry
     */
    public String getCcountry() {
        return ccountry;
    }
    
    /**
     * 设置 国籍
     * @param ccountry 国籍
     */
    public void setCcountry(String ccountry) {
        this.ccountry = ccountry;
    }
    
    /**
     * 获取 学历
     * @return ceducation
     */
    public String getCeducation() {
        return ceducation;
    }
    
    /**
     * 设置 学历
     * @param ceducation 学历
     */
    public void setCeducation(String ceducation) {
        this.ceducation = ceducation;
    }
    
    /**
     * 获取 手机号
     * @return cmobile
     */
    public String getCmobile() {
        return cmobile;
    }
    
    /**
     * 设置 手机号
     * @param cmobile 手机号
     */
    public void setCmobile(String cmobile) {
        this.cmobile = cmobile;
    }
    
    /**
     * 获取 姓名
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 姓名
     * @param cname 姓名
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 编号
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    
    /**
     * 设置 编号
     * @param cno 编号
     */
    public void setCno(String cno) {
        this.cno = cno;
    }
    
    /**
     * 获取 QQ号
     * @return cqq
     */
    public String getCqq() {
        return cqq;
    }
    
    /**
     * 设置 QQ号
     * @param cqq QQ号
     */
    public void setCqq(String cqq) {
        this.cqq = cqq;
    }
    
    /**
     * 获取 性别【男；女】
     * @return csex
     */
    public String getCsex() {
        return csex;
    }
    
    /**
     * 设置 性别【男；女】
     * @param csex 性别【男；女】
     */
    public void setCsex(String csex) {
        this.csex = csex;
    }
    
    /**
     * 获取 更新日期
     * @return dupdate
     */
    public Date getDupdate() {
        return dupdate;
    }
    
    /**
     * 设置 更新日期
     * @param dupdate 更新日期
     */
    public void setDupdate(Date dupdate) {
        this.dupdate = dupdate;
    }
    
}
