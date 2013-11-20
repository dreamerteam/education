package com.dreamer.education.bean.ro;

import java.io.Serializable;
import java.util.Date;

public class ResourceResponse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -97116452319130621L;
    
    /** 主键ID */
    private String uuid;
    
    /** 搜索关键字 */
    private String ckeyword;
    
    /** 名称 */
    private String cname;
    
    /** 类型【ppt、word、audio、video】 */
    private String ctype;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 免费【0:不免费；1：免费】 */
    private String cfree;
    
    /** 图片上传路径 */
    private String cpictureurl;
    
    /** 简介 */
    private String cdescription;
    
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
    
}
