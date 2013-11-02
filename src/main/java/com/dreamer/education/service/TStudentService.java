package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.dao.TStudentDao;

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
}
