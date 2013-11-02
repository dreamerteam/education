package com.dreamer.education.service;

import static com.dreamer.education.utils.PinyinUtils.getPinYin;
import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.ro.CourseTypeResponse;
import com.dreamer.education.dao.TCourseTypeDao;
import com.dreamer.education.utils.Page;

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
        courseType.setCstatus("1");
        courseType.setCpinyin(getPinYin(courseType.getCname()));
        courseType.setDcreate(new Date());
        courseType.setDupdate(courseType.getDcreate());
        courseType.setUuserid(getUUID());
        courseTyperDao.save(courseType);
    }
    
    /**
     * 更新课程类型
     * @param courseType 课程类型
     * @author broken_xie
     */
    public void update(TCourseType courseType) {
        TCourseType ct = courseTyperDao.findByUuid(courseType.getUuid());
        ct.setCcode(courseType.getCcode());
        ct.setCname(courseType.getCname());
        courseType.setCpinyin(getPinYin(courseType.getCname()));
        ct.setIlevel(courseType.getIlevel());
        ct.setUparentid(courseType.getUparentid());
        ct.setDupdate(new Date());
        ct.setUuserid(getUUID());
        courseTyperDao.update(ct);
    }
    
    /**
     * 删除课程类型
     * @param uuid 课程类型uuid
     * @author broken_xie
     */
    public void delete(String ccode) {
        courseTyperDao.delete(ccode);
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
    
    /**
     * 分页查询课程类型集合
     * @param cname 课程类型名称
     * @param currentPage 当前页码
     * @return
     * @author broken_xie
     */
    public Page<TCourseType> findPageByQuery(String cname, int currentPage) {
        Page<TCourseType> page = new Page<TCourseType>(currentPage);
        return courseTyperDao.findPageByQuery(cname, page);
    }
    
    /**
     * 根据课程类型uuid查找课程类型【编辑、查看】
     * @param uuid 课程类型uuid
     * @return
     * @author broken_xie
     */
    public CourseTypeResponse findForView(String uuid) {
        CourseTypeResponse response = courseTyperDao.findForView(uuid);
        String[] codes = response.getCcode().split("\\|");
        response.setCcode(codes[codes.length - 1]);
        return response;
    }
}
