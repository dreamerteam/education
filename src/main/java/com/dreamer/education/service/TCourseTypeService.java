package com.dreamer.education.service;

import org.springframework.stereotype.Service;

/**
 * 课程类型业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TCourseTypeService {
    //
    // /** 课程类型数据访问接口 */
    // @Autowired
    // private TCourseTyperRep courseTyperRep;
    //
    // /**
    // * 新增课程类型
    // * @param courseType 课程类型
    // * @author broken_xie
    // */
    // public void add(TCourseType courseType) {
    // TCourseType subCourseType = courseType.getTcourseType();
    // courseType.setIlevel(isEmptyString(subCourseType.getUuid()) ? 1 : subCourseType.getIlevel() + 1);
    // // courseType.setUparentid(uparentid)
    // courseType.setUuid(getPrimaryKey());
    // courseType.setDcreate(new Date());
    // courseType.setDupdate(courseType.getDcreate());
    // courseTyperRep.save(courseType);
    // }
    //
    // /**
    // * 课程类型名称是否已经存在【true：存在；false：不存在】
    // * @param cname 课程类型名称
    // * @return
    // * @author broken_xie
    // */
    // public boolean isCnameExist(String cname) {
    // return null == courseTyperRep.findByCname(cname) ? false : true;
    // }
}
