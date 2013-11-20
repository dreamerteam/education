package com.dreamer.education.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.bean.ro.StudentResponse;
import com.dreamer.education.dao.TStudentDao;
import com.dreamer.education.utils.Page;

/**
 * 学生业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TStudentService {
    
    /** 学生数据访问接口 */
    @Autowired
    private TStudentDao studentDao;
    
    /**
     * 根据uuid查找学生信息
     * @param uuid 学生uuid
     * @return
     * @author broken_xie
     */
    public TStudent findByUuid(String uuid) {
        return studentDao.findByUuid(uuid);
    }
    
    /**
     * 根据uuid查找学生信息
     * @param student 学生信息
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public TStudent update(TStudent student, SessionContainer sessionContainer) {
        TStudent s = studentDao.findByUuid(student.getUuid());
        s.setCaddress(student.getCaddress());
        s.setCcountry(student.getCcountry());
        s.setCeducation(student.getCeducation());
        s.setCemail(student.getCemail());
        s.setCfixedline(student.getCfixedline());
        s.setCidcard(student.getCidcard());
        s.setCmobile(student.getCmobile());
        s.setCmsn(student.getCmsn());
        s.setCname(student.getCname());
        s.setCnativeplace(student.getCnativeplace());
        s.setCnickname(student.getCnickname());
        s.setCqq(student.getCqq());
        s.setCsex(student.getCsex());
        s.setDbirthday(student.getDbirthday());
        s.setDupdate(new Date());
        studentDao.update(s);
        return s;
    }
    
    /**
     * 分页查询学生信息集合
     * @param currentPage 当前页码
     * @return
     * @author broken_xie
     */
    public Page<StudentResponse> findPageByQuery(int currentPage) {
        Page<StudentResponse> page = new Page<StudentResponse>(currentPage);
        return studentDao.findPageByQuery(page);
    }
    
    /**
     * 根据学生uuid查找学生【查看】
     * @param uuid 学生uuid
     * @return
     * @author broken_xie
     */
    public TStudent findForView(String uuid) {
        TStudent student = studentDao.findForView(uuid);
        return student;
    }
}
