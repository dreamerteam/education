package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【操作日志】
 * @since 2013-10-20 下午12:31:18
 * @author broken_xie
 */
@TableMapper(name = "t_operate_log")
public class TOperateLog implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -600632516701284111L;
    
    /** 主键ID */
    private String uuid;
    
    /** IP地址 */
    private String cip;
    
    /** 备注 */
    private String cmemo;
    
    /** 类型 */
    private String ctype;
    
    /** URL地址 */
    private String curl;
    
    /** 操作时间 */
    private Date doperate;
    
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
     * 获取 IP地址
     * @return cip
     */
    public String getCip() {
        return cip;
    }
    
    /**
     * 设置 IP地址
     * @param cip IP地址
     */
    public void setCip(String cip) {
        this.cip = cip;
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
     * 获取 类型
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 类型
     * @param ctype 类型
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 URL地址
     * @return curl
     */
    public String getCurl() {
        return curl;
    }
    
    /**
     * 设置 URL地址
     * @param curl URL地址
     */
    public void setCurl(String curl) {
        this.curl = curl;
    }
    
    /**
     * 获取 操作时间
     * @return doperate
     */
    public Date getDoperate() {
        return doperate;
    }
    
    /**
     * 设置 操作时间
     * @param doperate 操作时间
     */
    public void setDoperate(Date doperate) {
        this.doperate = doperate;
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
