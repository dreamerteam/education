package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.dao.TTeacherDao;

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
    
    /**
     * 根据uuid查找教师信息
     * @param uuid 教师uuid
     * @return
     * @author broken_xie
     */
    public TTeacher findByUuid(String uuid) {
        return teacherDao.findByUuid(uuid);
    }
}
