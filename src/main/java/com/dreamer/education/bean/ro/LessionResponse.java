package com.dreamer.education.bean.ro;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程响应对象
 * @since 2013-10-25 上午10:23:31
 * @author broken_xie
 */
public class LessionResponse implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -3293703533855416330L;
    
    /** 主键ID */
    private String uuid;
    
    /** 开课时间 */
    private Date dlession;
    
    /** 课程名称 */
    private String ccoursename;
    
    /** 热门度 */
    private int ihot;
    
    /** 课程类型名称 */
    private String ctypename;
    
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
     * 获取 开课时间
     * @return dlession
     */
    public Date getDlession() {
        return dlession;
    }
    
    /**
     * 设置 开课时间
     * @param dlession 开课时间
     */
    public void setDlession(Date dlession) {
        this.dlession = dlession;
    }
    
    /**
     * 获取 课程名称
     * @return ccoursename
     */
    public String getCcoursename() {
        return ccoursename;
    }
    
    /**
     * 设置 课程名称
     * @param ccoursename 课程名称
     */
    public void setCcoursename(String ccoursename) {
        this.ccoursename = ccoursename;
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
     * 获取 课程类型名称
     * @return ctypename
     */
    public String getCtypename() {
        return ctypename;
    }
    
    /**
     * 设置 课程类型名称
     * @param ctypename 课程类型名称
     */
    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }
}
