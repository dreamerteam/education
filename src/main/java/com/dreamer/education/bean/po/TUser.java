package com.dreamer.education.bean.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类【用户登录】
 * @since 2013-10-20 下午12:50:47
 * @author broken_xie
 */
@TableMapper(name = "t_user")
public class TUser implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -1579173933864801412L;
    
    /** 主键ID */
    private String uuid;
    
    /** 登录名 */
    private String clogin;
    
    /** 备注 */
    private String cmemo;
    
    /** 密码 */
    private String cpassword;
    
    /** 状态（0:停用 1:启用） */
    private String cstatus;
    
    /** 用户类型【supermanager，manager，teacher，student】 */
    private String ctype;
    
    /** 创建时间 */
    private Date dcreate;
    
    /** 更新时间 */
    private Date dupdate;
    
    /** 指向用户信息表【t_manager.uuid, t_teacher.uuid, t_student.uuid】 */
    private String upersonid;
    
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
     * 获取 登录名
     * @return clogin
     */
    public String getClogin() {
        return clogin;
    }
    
    /**
     * 设置 登录名
     * @param clogin 登录名
     */
    public void setClogin(String clogin) {
        this.clogin = clogin;
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
     * 获取 密码
     * @return cpassword
     */
    public String getCpassword() {
        return cpassword;
    }
    
    /**
     * 设置 密码
     * @param cpassword 密码
     */
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    /**
     * 获取 状态（0:停用 1:启用）
     * @return cstatus
     */
    public String getCstatus() {
        return cstatus;
    }
    
    /**
     * 设置 状态（0:停用 1:启用）
     * @param cstatus 状态（0:停用 1:启用）
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }
    
    /**
     * 获取 用户类型【supermanager，manager，teacher，student】
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 用户类型【supermanager，manager，teacher，student】
     * @param ctype 用户类型【supermanager，manager，teacher，student】
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
     * 获取 指向用户信息表【t_manager.uuid t_teacher.uuid t_student.uuid】
     * @return upersonid
     */
    public String getUpersonid() {
        return upersonid;
    }
    
    /**
     * 设置 指向用户信息表【t_manager.uuid t_teacher.uuid t_student.uuid】
     * @param upersonid 指向用户信息表【t_manager.uuid t_teacher.uuid t_student.uuid】
     */
    public void setUpersonid(String upersonid) {
        this.upersonid = upersonid;
    }
    
}
