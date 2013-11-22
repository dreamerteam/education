package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【上课时间】
 * @since 2013-10-20 下午12:22:47
 * @author broken_xie
 */
@TableMapper(name = "t_lession")
public class TLession implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -6547228845782310604L;
    
    /** 主键ID */
    private String uuid;
    
    /** 上课对象【teacher, student】 */
    private String cobject;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 开课起始时间 */
    private Date dbgnlession;
    
    /** 开课结束时间 */
    private Date dendlession;
    
    /** 开课间隔时间【每天、周末、周一....】 */
    private String cperiod;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 课程ID */
    private String ucourseid;
    
    /** 学生ID */
    private String ustudentid;
    
    /** 教师ID */
    private String uteacherid;
    
    /** 操作用户ID */
    private String uuserid;
    
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
     * 获取 上课对象【teacher student】
     * @return cobject
     */
    public String getCobject() {
        return cobject;
    }
    
    /**
     * 设置 上课对象【teacher student】
     * @param cobject 上课对象【teacher student】
     */
    public void setCobject(String cobject) {
        this.cobject = cobject;
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
     * 获取 开课起始时间
     * @return dbgnlession
     */
    public Date getDbgnlession() {
        return dbgnlession;
    }
    
    /**
     * 设置 开课起始时间
     * @param dbgnlession 开课起始时间
     */
    public void setDbgnlession(Date dbgnlession) {
        this.dbgnlession = dbgnlession;
    }
    
    /**
     * 获取 开课结束时间
     * @return dendlession
     */
    public Date getDendlession() {
        return dendlession;
    }
    
    /**
     * 设置 开课结束时间
     * @param dendlession 开课结束时间
     */
    public void setDendlession(Date dendlession) {
        this.dendlession = dendlession;
    }
    
    /**
     * 获取 开课间隔时间【每天、周末、周一....】
     * @return cperiod
     */
    public String getCperiod() {
        return cperiod;
    }
    
    /**
     * 设置 开课间隔时间【每天、周末、周一....】
     * @param cperiod 开课间隔时间【每天、周末、周一....】
     */
    public void setCperiod(String cperiod) {
        this.cperiod = cperiod;
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
     * 获取 课程ID
     * @return ucourseid
     */
    public String getUcourseid() {
        return ucourseid;
    }
    
    /**
     * 设置 课程ID
     * @param ucourseid 课程ID
     */
    public void setUcourseid(String ucourseid) {
        this.ucourseid = ucourseid;
    }
    
    /**
     * 获取 学生ID
     * @return ustudentid
     */
    public String getUstudentid() {
        return ustudentid;
    }
    
    /**
     * 设置 学生ID
     * @param ustudentid 学生ID
     */
    public void setUstudentid(String ustudentid) {
        this.ustudentid = ustudentid;
    }
    
    /**
     * 获取 教师ID
     * @return uteacherid
     */
    public String getUteacherid() {
        return uteacherid;
    }
    
    /**
     * 设置 教师ID
     * @param uteacherid 教师ID
     */
    public void setUteacherid(String uteacherid) {
        this.uteacherid = uteacherid;
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
