package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【课程类型】
 * @since 2013-10-20 下午12:19:52
 * @author broken_xie
 */
@TableMapper(name = "t_course_type")
public class TCourseType implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 6437904547554548327L;
    
    /** 名称 */
    private String cname;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 等级【0最高等级】 */
    private int ilevel;
    
    /** 父级ID */
    private String uparentid;
    
    /** 操作用户ID */
    private String uuserid;
    
    /** 主键ID */
    private String uuid;
    
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
     * 获取 等级【0最高等级】
     * @return ilevel
     */
    public int getIlevel() {
        return ilevel;
    }
    
    /**
     * 设置 等级【0最高等级】
     * @param ilevel 等级【0最高等级】
     */
    public void setIlevel(int ilevel) {
        this.ilevel = ilevel;
    }
    
    /**
     * 获取 父级ID
     * @return uparentid
     */
    public String getUparentid() {
        return uparentid;
    }
    
    /**
     * 设置 父级ID
     * @param uparentid 父级ID
     */
    public void setUparentid(String uparentid) {
        this.uparentid = uparentid;
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
