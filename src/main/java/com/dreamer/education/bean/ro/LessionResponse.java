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
    
    /** 开课起始日期 */
    private Date dbgnlession;
    
    /** 开课结束日期 */
    private Date dendlession;
    
    /** 开课时间 */
    private String ctime;
    
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
     * 获取 开课起始日期
     * @return dbgnlession
     */
    public Date getDbgnlession() {
        return dbgnlession;
    }
    
    /**
     * 设置 开课起始日期
     * @param dbgnlession 开课起始日期
     */
    public void setDbgnlession(Date dbgnlession) {
        this.dbgnlession = dbgnlession;
    }
    
    /**
     * 获取 开课结束日期
     * @return dendlession
     */
    public Date getDendlession() {
        return dendlession;
    }
    
    /**
     * 设置 开课结束日期
     * @param dendlession 开课结束日期
     */
    public void setDendlession(Date dendlession) {
        this.dendlession = dendlession;
    }
    
    /**
     * 获取 开课时间
     * @return ctime
     */
    public String getCtime() {
        return ctime;
    }
    
    /**
     * 设置 开课时间
     * @param ctime 开课时间
     */
    public void setCtime(String ctime) {
        this.ctime = ctime;
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
