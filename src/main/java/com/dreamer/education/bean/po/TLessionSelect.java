package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【选课】
 * @since 2013-10-20 下午12:24:52
 * @author broken_xie
 */
@TableMapper(name = "t_lession_select")
public class TLessionSelect implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -1993074147136593198L;
    
    /** 主键ID */
    private String uuid;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 课程ID */
    private String ucourseid;
    
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
