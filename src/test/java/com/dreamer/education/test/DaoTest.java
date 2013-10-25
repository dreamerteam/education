package com.dreamer.education.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.ro.CourseTypeResponse;
import com.dreamer.education.dao.TCourseTypeDao;
import com.dreamer.education.test.base.BaseTest;

/**
 * 数据访问接口测试类
 * @since 2013-10-18 下午2:35:02
 * @author broken_xie
 */
public class DaoTest extends BaseTest {
    
    /** 课程类型 数据访问接口 */
    @Autowired
    private TCourseTypeDao courseTypeDao;
    
    @Test
    public void test() {
//        List<TCourseType> courseTypes = courseTypeDao.findByCname("语文2");
//        List<TCourseType> courseTypes = courseTypeDao.findByCcode("");
        CourseTypeResponse response = courseTypeDao.findForView("0af12869-6ccd-45be-9ecb-c67c55955ef8");
        System.out.println(response.getUuid() + "\t" + response.getCname());
//        for (TCourseType courseType : courseTypes) {
//            System.out.println(courseType.getUuid() + "\t" + courseType.getCname());
//        }
        // List<TCourseType> courseTypes = courseTypeDao.findAll();
        // for (TCourseType courseType : courseTypes) {
        // System.out.println(courseType.getCname()+"\t"+courseType.getUuid());
        // }
        // TCourseType courseType = new TCourseType();
        // courseType.setUuid(UUID.randomUUID().toString());
        // courseType.setCname("英文");
        // courseType.setDcreate(new Date());
        // courseType.setDupdate(courseType.getDcreate());
        // courseType.setIlevel(0);
        // courseType.setUuserid(UUID.randomUUID().toString());
        // courseTypeDao.save(courseType);
        // List<Map<String, Object>> list = courseTypeDao.findForAutoComplete();
        // for (Map<String, Object> map : list) {
        // System.out.println(map.get("label") + "\t" + map.get("value"));
        // }
        //
        // Map<String, Object> map = courseTypeDao.getJdbcTemplate().queryForMap(sql, new HashMap<String, Object>());
        // for (Object o : map.keySet()) {
        // System.out.println(map.get(o));
        // }
    }
}
