package com.dreamer.education.bean.co;

import java.io.Serializable;

import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.po.TUser;

/**
 * 登录会话容器
 * @since 2013-10-29 上午9:55:17
 * @author broken_xie
 */
public class SessionContainer implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 2540443689427481770L;
    
    /** 实体类【用户登录】 */
    private TUser user;
    
    /** 实体类【教师】 */
    private TTeacher teacher;
    
    /** 实体类【管理员信息】 */
    private TManager manager;
    
    /** 实体类【学生】 */
    private TStudent student;
    
    /** 权限类型【manager：管理员；teacher：教师；student：学生】 */
    private String authority;
    
    /**
     * 获取 实体类【用户登录】
     * @return user
     */
    public TUser getUser() {
        return user;
    }
    
    /**
     * 设置 实体类【用户登录】
     * @param user 实体类【用户登录】
     */
    public void setUser(TUser user) {
        this.user = user;
    }
    
    /**
     * 获取 实体类【教师】
     * @return teacher
     */
    public TTeacher getTeacher() {
        return teacher;
    }
    
    /**
     * 设置 实体类【教师】
     * @param teacher 实体类【教师】
     */
    public void setTeacher(TTeacher teacher) {
        this.teacher = teacher;
    }
    
    /**
     * 获取 实体类【管理员信息】
     * @return manager
     */
    public TManager getManager() {
        return manager;
    }
    
    /**
     * 设置 实体类【管理员信息】
     * @param manager 实体类【管理员信息】
     */
    public void setManager(TManager manager) {
        this.manager = manager;
    }
    
    /**
     * 获取 实体类【学生】
     * @return student
     */
    public TStudent getStudent() {
        return student;
    }
    
    /**
     * 设置 实体类【学生】
     * @param student 实体类【学生】
     */
    public void setStudent(TStudent student) {
        this.student = student;
    }
    
    /**
     * 获取 权限类型【manager：管理员；teacher：教师；student：学生】
     * @return authority
     */
    public String getAuthority() {
        return authority;
    }
    
    /**
     * 设置 权限类型【manager：管理员；teacher：教师；student：学生】
     * @param authority 权限类型【manager：管理员；teacher：教师；student：学生】
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
}
