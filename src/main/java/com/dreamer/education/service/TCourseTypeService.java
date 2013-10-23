package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.dao.TCourseTypeDao;

/**
 * 课程类型业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TCourseTypeService {
    
    /** 课程类型数据访问接口 */
    @Autowired
    private TCourseTypeDao courseTyperDao;
    
    /**
     * 新增课程类型
     * @param courseType 课程类型
     * @author broken_xie
     */
    public void add(TCourseType courseType) {
        courseType.setUuid(getUUID());
        courseType.setDcreate(new Date());
        courseType.setDupdate(courseType.getDcreate());
        courseType.setUuserid(getUUID());
        courseTyperDao.save(courseType);
    }
    
    /**
     * 课程类型名称是否已经存在【true：存在；false：不存在】
     * @param cname 课程类型名称
     * @return
     * @author broken_xie
     */
    public boolean isCnameExist(String cname) {
        return 0 == courseTyperDao.findByCname(cname).size() ? false : true;
    }
    
    /**
     * 课程类型代码是否已经存在【true：存在；false：不存在】
     * @param ccode 课程类型代码
     * @return
     * @author broken_xie
     */
    public boolean isCcodeExist(String ccode) {
        return 0 == courseTyperDao.findByCcode(ccode).size() ? false : true;
    }
}
