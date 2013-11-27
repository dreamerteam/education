package com.dreamer.education.service;

import static com.dreamer.education.utils.Encryption.MD5;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.bean.ro.PersonalRequest;
import com.dreamer.education.dao.TManagerDao;
import com.dreamer.education.dao.TTeacherDao;
import com.dreamer.education.dao.TUserDao;

/**
 * 个人中心业务访问接口
 * @since 2013-11-13 下午3:14:34
 * @author broken_xie
 */
@Service
public class PersonalService {
    
    /** 管理员数据访问接口 */
    @Autowired
    private TManagerDao managerDao;
    
    /** 教师数据访问接口 */
    @Autowired
    private TTeacherDao teacherDao;
    
    /** 用户数据访问接口 */
    @Autowired
    private TUserDao userDao;
    
    /**
     * 更新个人信息
     * @param personal 个人信息请求对象
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public Map<String, Object> update(PersonalRequest personal, SessionContainer sessionContainer) {
        Map<String, Object> map = new HashMap<String, Object>();
        String authority = sessionContainer.getAuthority();
        map.put("authority", authority);
        switch (authority) {
            case "manager":
                TManager m = managerDao.findByUuid(personal.getUuid());
                m.setCaddress(personal.getCaddress());
                m.setCcountry(personal.getCcountry());
                m.setCeducation(personal.getCeducation());
                m.setCemail(personal.getCemail());
                m.setCfixedline(personal.getCfixedline());
                m.setCidcard(personal.getCidcard());
                m.setCmobile(personal.getCmobile());
                m.setCmsn(personal.getCmsn());
                m.setCnativeplace(personal.getCnativeplace());
                m.setCqq(personal.getCqq());
                m.setDbirthday(personal.getDbirthday());
                m.setDupdate(new Date());
                managerDao.update(m);
                map.put("personal", m);
                break;
            case "teacher":
                TTeacher t = teacherDao.findByUuid(personal.getUuid());
                t.setCaddress(personal.getCaddress());
                t.setCcountry(personal.getCcountry());
                t.setCeducation(personal.getCeducation());
                t.setCemail(personal.getCemail());
                t.setCfixedline(personal.getCfixedline());
                t.setCidcard(personal.getCidcard());
                t.setCmobile(personal.getCmobile());
                t.setCmsn(personal.getCmsn());
                t.setCnativeplace(personal.getCnativeplace());
                t.setCnickname(personal.getCnickname());
                t.setCqq(personal.getCqq());
                t.setDbirthday(personal.getDbirthday());
                t.setDupdate(new Date());
                teacherDao.update(t);
                map.put("personal", t);
                break;
            default:
                break;
        }
        return map;
    }
    
    /**
     * 更新密码
     * @param psw 密码
     * @param sessionContainer 会话容器
     * @author broken_xie
     */
    public TUser updatePsw(String psw, SessionContainer sessionContainer) {
        TUser user = userDao.findByUuid(sessionContainer.getUser().getUuid());
        user.setCpassword(MD5(psw));
        user.setDupdate(new Date());
        userDao.update(user);
        return user;
    }
}
