package com.dreamer.education.service;

import static com.dreamer.education.utils.Encryption.MD5;
import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.dao.TStudentDao;
import com.dreamer.education.dao.TUserDao;

/**
 * 用户业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TUserService {
    
    /** 用户数据访问接口 */
    @Autowired
    private TUserDao userDao;
    
    /** 学生数据访问接口 */
    @Autowired
    private TStudentDao studentDao;
    
    /**
     * 根据登录名获取用户信息
     * @param clogin 登录名
     * @return
     * @author broken_xie
     */
    public TUser findByClogin(String clogin) {
        return userDao.findByClogin(clogin);
    }
    
    /**
     * 登录名是否已经存在【true：存在；false：不存在】
     * @param clogin 登录名
     * @return
     * @author broken_xie
     */
    public boolean isCloginExist(String clogin) {
        return null == userDao.findByClogin(clogin) ? false : true;
    }
    
    /**
     * 用户注册
     * @param user 实体类【用户登录】
     * @param ctype 用户类型【supermanager，manager，teacher，student】
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public void register(TUser user, String ctype, SessionContainer sessionContainer) {
        Date now = new Date();
        String upersionid = getUUID();
        if ("student".equals(ctype)) {
            TStudent student = new TStudent();
            student.setUuid(upersionid);
            student.setCname(user.getClogin());
            student.setDcreate(now);
            student.setDupdate(now);
            studentDao.save(student);
        }
        user.setCstatus("1");
        user.setCtype("student");
        user.setCpassword(MD5(user.getCpassword()));
        user.setDcreate(now);
        user.setDupdate(now);
        user.setUpersonid(upersionid);
        user.setUuid(getUUID());
        userDao.save(user);
    }
}
