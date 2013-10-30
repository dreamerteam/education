package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.bean.ro.CourseTypeResponse;
import com.dreamer.education.dao.TCourseDao;
import com.dreamer.education.dao.TCourseTypeDao;
import com.dreamer.education.utils.Page;

/*
* @author Owen
* @version 创建时间：2013年10月28日 下午3:10:57 
*/ 
@Service
public class TCourseService {
	@Autowired
    private TCourseDao courseDao;
	
	@Autowired
	private TCourseTypeDao courseTypeDao;
	
	public void add(TCourse course) {
        course.setUuid(getUUID());
        course.setCaudit("10");
        course.setCstatus("1");
        course.setIhot(0);
        course.setDcreate(new Date());
        course.setDupdate(course.getDcreate());
        course.setUuserid(getUUID());
        courseDao.save(course);
    }
   
    public void update(CourseResponse course) {
        TCourse ct = courseDao.findByUuid(course.getUuid());
        ct.setCname(course.getCname());
        ct.setCdescription(course.getCdescription());
        TCourseType courseType=courseTypeDao.findByCname(course.getUtypename()).get(0);
        ct.setUtypeid(courseType.getUuid());
        ct.setDupdate(new Date());
        ct.setUuserid(getUUID());
        courseDao.update(ct);
    }
    
  
    public void delete(String uuid) {
        courseDao.delete(uuid);
    }
   
    public boolean isCnameExist(String cname) {
        return 0 == courseDao.findByCname(cname).size() ? false : true;
    }
    
    public Page<TCourse> findPageByQuery(String cname, int currentPage) {
        Page<TCourse> page = new Page<TCourse>(currentPage);
        return courseDao.findPageByQuery(cname, page);
    }
   
    
    public CourseResponse findForView(String uuid) {
    	TCourse course=courseDao.findByUuid(uuid);
    	TCourseType courseType=courseTypeDao.findByUuid(course.getUtypeid());
        CourseResponse response = new CourseResponse();
        response.setUuid(course.getUuid());
        response.setUtypeid(course.getUtypeid());
        response.setUtypename(courseType.getCname());
        response.setCname(course.getCname());
        response.setCdescription(course.getCdescription());
        return response;
    }
}
