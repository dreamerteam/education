package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.bean.ro.TeacherResponse;
import com.dreamer.education.dao.TTeacherDao;
import com.dreamer.education.dao.TUserDao;
import com.dreamer.education.utils.Page;

/**
 * 教师业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TTeacherService {
    
    /** 教师数据访问接口 */
    @Autowired
    private TTeacherDao teacherDao;
    
    /** 用户数据访问接口 */
    @Autowired
    private TUserDao userDao;
    
    /**
     * 根据uuid查找教师信息
     * @param uuid 教师uuid
     * @return
     * @author broken_xie
     */
    public TTeacher findByUuid(String uuid) {
        return teacherDao.findByUuid(uuid);
    }
    
    /**
     * 查找热门教师
     * @return
     * @author broken_xie
     */
    public List<TTeacher> findForHot() {
        return teacherDao.findForHot();
    }
    
    /**
     * 添加教师信息
     * @param user 登录信息
     * @param teacher 教师信息
     * @param sessionContainer 会话容器
     * @author broken_xie
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(TUser user, TTeacher teacher, SessionContainer sessionContainer) {
        Date now = new Date();
        String upersonid = getUUID();
        user.setCstatus("1");
        user.setCtype("teacher");
        user.setDcreate(now);
        user.setDupdate(now);
        user.setUpersonid(upersonid);
        user.setUuid(getUUID());
        userDao.save(user);
        teacherDao.findMaxCno();
        String maxCno = teacherDao.findMaxCno();
        teacher.setCno("wanhua" + (isEmpty(maxCno) ? "0000001" : maxCno));
        teacher.setDcreate(now);
        teacher.setDupdate(now);
        teacher.setUuid(getUUID());
        teacherDao.save(teacher);
    }
    
    /**
     * 分页查询教师信息集合
     * @param currentPage 当前页码
     * @return
     * @author broken_xie
     */
    public Page<TeacherResponse> findPageByQuery(int currentPage) {
        Page<TeacherResponse> page = new Page<TeacherResponse>(currentPage);
        return teacherDao.findPageByQuery(page);
    }
    
    /**
     * 根据教师uuid查找教师【查看】
     * @param uuid 教师uuid
     * @return
     * @author broken_xie
     */
    public TTeacher findForView(String uuid) {
        TTeacher teacher = teacherDao.findForView(uuid);
        return teacher;
    }
    
    /**
     * 根据uuid查找教师信息
     * @param teacher 教师信息
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public TTeacher update(TTeacher teacher, SessionContainer sessionContainer) {
        TTeacher t = teacherDao.findByUuid(teacher.getUuid());
        t.setCaddress(teacher.getCaddress());
        t.setCcountry(teacher.getCcountry());
        t.setCeducation(teacher.getCeducation());
        t.setCemail(teacher.getCemail());
        t.setCfixedline(teacher.getCfixedline());
        t.setCidcard(teacher.getCidcard());
        t.setCmobile(teacher.getCmobile());
        t.setCmsn(teacher.getCmsn());
        t.setCname(teacher.getCname());
        t.setCnativeplace(teacher.getCnativeplace());
        t.setCnickname(teacher.getCnickname());
        t.setCqq(teacher.getCqq());
        t.setCsex(teacher.getCsex());
        t.setDbirthday(teacher.getDbirthday());
        t.setDupdate(new Date());
        teacherDao.update(t);
        return t;
    }
}
