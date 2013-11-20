package com.dreamer.education.bean.ro;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人中心请求对象
 * @since 2013-11-13 下午4:35:10
 * @author broken_xie
 */
public class PersonalRequest implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -8535962244154366918L;
    
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
    
    /** 籍贯 */
    private String cnativeplace;
    
    /** 昵称 */
    private String cnickname;
    
    /** 编号 */
    private String cno;
    
    /** QQ号 */
    private String cqq;
    
    /** 生日 */
    private Date dbirthday;
    
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
    
}
