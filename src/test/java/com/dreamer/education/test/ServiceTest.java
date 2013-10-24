package com.dreamer.education.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.service.TCourseTypeService;
import com.dreamer.education.test.base.BaseTest;
import com.dreamer.education.utils.Page;

/**
 * 业务访问层接口测试类
 * @since 2013-10-25 下午2:19:28
 * @author broken_xie
 */
public class ServiceTest extends BaseTest {
    
    /** 课程类型业务访问接口 */
    @Autowired
    private TCourseTypeService courseTypeService;
    
    @Test
    public void test() {
        Page<TCourseType> page = courseTypeService.findPageByQuery(null, 1);
        List<TCourseType> courseTypes = page.getResultRows();
        for (TCourseType courseType : courseTypes) {
            System.out.println(courseType.getUuid() + "\t" + courseType.getCname());
        }
    }
    
}
