package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【资源上传】
 * @since 2013-10-20 下午12:33:24
 * @author broken_xie
 */
@TableMapper(name = "t_resource")
public class TResource implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -8628561762346706529L;
    
    /** 主键ID */
    private String uuid;
    
    /** 简介 */
    private String cdescription;
    
    /** 搜索关键字 */
    private String ckeyword;
    
    /** 名称 */
    private String cname;
    
    /** 资源上传路径 */
    private String cpath;
    
    /** 图片上传路径 */
    private String cpictureurl;
    
    /** 资源大小KB */
    private String csize;
    
    /** 类型【ppt、word、audio、video】 */
    private String ctype;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 操作用户ID */
    private String uuserid;
    
    /** 免费【0:不免费；1：免费】 */
    private String cfree;
    
    /**
     * 获取 免费【0:不免费；1：免费】
     * @return cfree
     */
    public String getCfree() {
        return cfree;
    }
    
    /**
     * 设置 免费【0:不免费；1：免费】
     * @param cfree 免费【0:不免费；1：免费】
     */
    public void setCfree(String cfree) {
        this.cfree = cfree;
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
     * 获取 资源上传路径
     * @return cpath
     */
    public String getCpath() {
        return cpath;
    }
    
    /**
     * 设置 资源上传路径
     * @param cpath 资源上传路径
     */
    public void setCpath(String cpath) {
        this.cpath = cpath;
    }
    
    /**
     * 获取 图片上传路径
     * @return cpictureurl
     */
    public String getCpictureurl() {
        return cpictureurl;
    }
    
    /**
     * 设置 图片上传路径
     * @param cpictureurl 图片上传路径
     */
    public void setCpictureurl(String cpictureurl) {
        this.cpictureurl = cpictureurl;
    }
    
    /**
     * 获取 资源大小KB
     * @return csize
     */
    public String getCsize() {
        return csize;
    }
    
    /**
     * 设置 资源大小KB
     * @param csize 资源大小KB
     */
    public void setCsize(String csize) {
        this.csize = csize;
    }
    
    /**
     * 获取 类型【ppt、word、audio、video】
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 类型【ppt、word、audio、video】
     * @param ctype 类型【ppt、word、audio、video】
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
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
