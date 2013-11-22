package com.dreamer.education.bean.ro;

import java.io.Serializable;

/**
 * 课程响应对象
 * @since 2013-10-25 上午10:23:31
 * @author broken_xie
 */
public class CourseResponse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -3293703533855416330L;
    
    /** 主键ID */
    private String uuid;
    
    /** 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】 */
    private String caudit;
    
    /** 简介 */
    private String cdescription;
    
    /** 搜索关键字 */
    private String ckeyword;
    
    /** 名称 */
    private String cname;
    
    /** 状态【0：未启用；1：启用】 */
    private String cstatus;
    
    /** 热门度 */
    private int ihot;
    
    /** 课程类型 */
    private String ctypename;
    
    /** 课程类型id */
    private String utypeid;
    
    /** 是否开课【0：待开课；1：开课】 */
    private String copen;
    
    /** 上课时间表uuid */
    private String ulessionid;
    
    /**
     * 获取 上课时间表uuid
     * @return ulessionid
     */
    public String getUlessionid() {
        return ulessionid;
    }
    
    /**
     * 设置 上课时间表uuid
     * @param ulessionid 上课时间表uuid
     */
    public void setUlessionid(String ulessionid) {
        this.ulessionid = ulessionid;
    }
    
    /**
     * 获取 是否开课【0：待开课；1：开课】
     * @return copen
     */
    public String getCopen() {
        return copen;
    }
    
    /**
     * 设置 是否开课【0：待开课；1：开课】
     * @param copen 是否开课【0：待开课；1：开课】
     */
    public void setCopen(String copen) {
        this.copen = copen;
    }
    
    /**
     * 获取 课程类型id
     * @return utypeid
     */
    public String getUtypeid() {
        return utypeid;
    }
    
    /**
     * 设置 课程类型id
     * @param utypeid 课程类型id
     */
    public void setUtypeid(String utypeid) {
        this.utypeid = utypeid;
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
     * 获取 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】
     * @return caudit
     */
    public String getCaudit() {
        return caudit;
    }
    
    /**
     * 设置 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】
     * @param caudit 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】
     */
    public void setCaudit(String caudit) {
        this.caudit = caudit;
    }
    
    /**
     * 获取 简介
     * @return cdescription
     */
    public String getCdescription() {
        return cdescription;
    }
    
    /**
     * 设置 简介
     * @param cdescription 简介
     */
    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }
    
    /**
     * 获取 搜索关键字
     * @return ckeyword
     */
    public String getCkeyword() {
        return ckeyword;
    }
    
    /**
     * 设置 搜索关键字
     * @param ckeyword 搜索关键字
     */
    public void setCkeyword(String ckeyword) {
        this.ckeyword = ckeyword;
    }
    
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
     * 获取 状态【0：未启用；1：启用】
     * @return cstatus
     */
    public String getCstatus() {
        return cstatus;
    }
    
    /**
     * 设置 状态【0：未启用；1：启用】
     * @param cstatus 状态【0：未启用；1：启用】
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }
    
    /**
     * 获取 热门度
     * @return ihot
     */
    public int getIhot() {
        return ihot;
    }
    
    /**
     * 设置 热门度
     * @param ihot 热门度
     */
    public void setIhot(int ihot) {
        this.ihot = ihot;
    }
    
    /**
     * 获取 课程类型
     * @return ctypename
     */
    public String getCtypename() {
        return ctypename;
    }
    
    /**
     * 设置 课程类型
     * @param ctypename 课程类型
     */
    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }
    
}
