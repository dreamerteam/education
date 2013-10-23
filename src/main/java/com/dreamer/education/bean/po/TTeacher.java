package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【教师】
 * @since 2013-10-20 下午12:47:10
 * @author broken_xie
 */
@TableMapper(name = "t_teacher")
public class TTeacher implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 1568446175846515380L;
    
    /** 主键ID */
    private String uuid;
    
    /** 住址 */
    private String caddress;
    
    /** 国籍 */
    private String ccountry;
    
    /** 学历 */
    private String ceducation;
    
    /** 邮箱地址 */
    private String cemail;
    
    /** 固话 */
    private String cfixedline;
    
    /** 身份证 */
    private String cidcard;
    
    /** 手机号 */
    private String cmobile;
    
    /** MSN号 */
    private String cmsn;
    
    /** 姓名 */
    private String cname;
    
    /** 籍贯 */
    private String cnativeplace;
    
    /** 昵称 */
    private String cnickname;
    
    /** 编号 */
    private String cno;
    
    /** QQ号 */
    private String cqq;
    
    /** 性别【男；女】 */
    private String csex;
    
    /** 生日 */
    private Date dbirthday;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 入职日期 */
    private Date dentry;
    
    /** 离职日期 */
    private Date dmission;
    
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
     * 获取 住址
     * @return caddress
     */
    public String getCaddress() {
        return caddress;
    }
    
    /**
     * 设置 住址
     * @param caddress 住址
     */
    public void setCaddress(String caddress) {
        this.caddress = caddress;
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
     * 获取 邮箱地址
     * @return cemail
     */
    public String getCemail() {
        return cemail;
    }
    
    /**
     * 设置 邮箱地址
     * @param cemail 邮箱地址
     */
    public void setCemail(String cemail) {
        this.cemail = cemail;
    }
    
    /**
     * 获取 固话
     * @return cfixedline
     */
    public String getCfixedline() {
        return cfixedline;
    }
    
    /**
     * 设置 固话
     * @param cfixedline 固话
     */
    public void setCfixedline(String cfixedline) {
        this.cfixedline = cfixedline;
    }
    
    /**
     * 获取 身份证
     * @return cidcard
     */
    public String getCidcard() {
        return cidcard;
    }
    
    /**
     * 设置 身份证
     * @param cidcard 身份证
     */
    public void setCidcard(String cidcard) {
        this.cidcard = cidcard;
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
     * 获取 MSN号
     * @return cmsn
     */
    public String getCmsn() {
        return cmsn;
    }
    
    /**
     * 设置 MSN号
     * @param cmsn MSN号
     */
    public void setCmsn(String cmsn) {
        this.cmsn = cmsn;
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
     * 获取 籍贯
     * @return cnativeplace
     */
    public String getCnativeplace() {
        return cnativeplace;
    }
    
    /**
     * 设置 籍贯
     * @param cnativeplace 籍贯
     */
    public void setCnativeplace(String cnativeplace) {
        this.cnativeplace = cnativeplace;
    }
    
    /**
     * 获取 昵称
     * @return cnickname
     */
    public String getCnickname() {
        return cnickname;
    }
    
    /**
     * 设置 昵称
     * @param cnickname 昵称
     */
    public void setCnickname(String cnickname) {
        this.cnickname = cnickname;
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
     * 获取 生日
     * @return dbirthday
     */
    public Date getDbirthday() {
        return dbirthday;
    }
    
    /**
     * 设置 生日
     * @param dbirthday 生日
     */
    public void setDbirthday(Date dbirthday) {
        this.dbirthday = dbirthday;
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
     * 获取 入职日期
     * @return dentry
     */
    public Date getDentry() {
        return dentry;
    }
    
    /**
     * 设置 入职日期
     * @param dentry 入职日期
     */
    public void setDentry(Date dentry) {
        this.dentry = dentry;
    }
    
    /**
     * 获取 离职日期
     * @return dmission
     */
    public Date getDmission() {
        return dmission;
    }
    
    /**
     * 设置 离职日期
     * @param dmission 离职日期
     */
    public void setDmission(Date dmission) {
        this.dmission = dmission;
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
