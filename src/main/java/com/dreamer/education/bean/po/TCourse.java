package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【课程】
 * @since 2013-10-20 下午12:15:26
 * @author broken_xie
 */
@TableMapper(name = "t_course")
public class TCourse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -7475072375404934543L;
    
    /** 主键ID */
    private String uuid;
    
    /** 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】 */
    private String caudit;
    
    /** 简介 */
    private String cdescription;
    
    /** 搜索关键字 */
    private String ckeyword;
    
    /** 备注 */
    private String cmemo;
    
    /** 名称 */
    private String cname;
    
    /** 状态【0：未启用；1：启用】 */
    private String cstatus;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 热门度 */
    private int ihot;
    
    /** 课程类型ID */
    private String utypeid;
    
    /** 操作用户ID */
    private String uuserid;
    
    /** 是否开课【0：待开课；1：开课】 */
    private String copen;
    
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
     * 获取 备注
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 备注
     * @param cmemo 备注
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
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
     * 获取 创建时间
     * @return dcreate
     */
    public Date getDcreate() {
        return dcreate;
    }
    
    /**
     * 设置 创建时间
     * @param dcreate 创建时间
     */
    public void setDcreate(Date dcreate) {
        this.dcreate = dcreate;
    }
    
    /**
     * 获取 更新时间
     * @return dupdate
     */
    public Date getDupdate() {
        return dupdate;
    }
    
    /**
     * 设置 更新时间
     * @param dupdate 更新时间
     */
    public void setDupdate(Date dupdate) {
        this.dupdate = dupdate;
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
     * 获取 课程类型ID
     * @return utypeid
     */
    public String getUtypeid() {
        return utypeid;
    }
    
    /**
     * 设置 课程类型ID
     * @param utypeid 课程类型ID
     */
    public void setUtypeid(String utypeid) {
        this.utypeid = utypeid;
    }
    
    /**
     * 获取 操作用户ID
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 操作用户ID
     * @param uuserid 操作用户ID
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
}
