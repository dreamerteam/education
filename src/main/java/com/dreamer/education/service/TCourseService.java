package com.dreamer.education.service;

import static com.dreamer.education.utils.DateUtils.toDate;
import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.po.TLession;
import com.dreamer.education.bean.qo.CourseQuery;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.bean.ro.OpenCourseRequest;
import com.dreamer.education.dao.TCourseDao;
import com.dreamer.education.dao.TLessionDao;
import com.dreamer.education.utils.Page;

/**
 * 课程业务访问接口
 * @since 2013-11-4 上午10:44:06
 * @author broken_xie
 */
@Service
public class TCourseService {
    
    /** 课程数据访问接口 */
    @Autowired
    private TCourseDao courseDao;
    
    /** 选课数据访问接口 */
    @Autowired
    private TLessionDao lessionDao;
    
    /**
     * 新增课程类型
     * @param courseType 课程类型
     * @author broken_xie
     */
    public void add(TCourse course, SessionContainer sessionContainer) {
        course.setUuid(getUUID());
        course.setCstatus("0");
        course.setUuserid(sessionContainer.getUser().getUuid());
        course.setIhot(0);
        course.setCaudit("0");
        course.setCopen("0");
        course.setDcreate(new Date());
        course.setDupdate(course.getDcreate());
        courseDao.save(course);
    }
    
    /**
     * 更新课程
     * @param course 课程
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public void update(TCourse course, SessionContainer sessionContainer) {
        TCourse c = courseDao.findByUuid(course.getUuid());
        c.setCname(course.getCname());
        c.setUtypeid(course.getUtypeid());
        c.setCkeyword(course.getCkeyword());
        c.setCdescription(course.getCdescription());
        c.setDupdate(new Date());
        c.setUuserid(sessionContainer.getUser().getUuid());
        courseDao.update(c);
    }
    
    /**
     * 修改课程审核状态
     * @param uuid 课程id
     * @param caudit 课程审核状态
     * @return
     * @author broken_xie
     */
    public void changeAudit(String uuid, String caudit) {
        TCourse c = courseDao.findByUuid(uuid);
        c.setCaudit(caudit);
        c.setDupdate(new Date());
        courseDao.update(c);
    }
    
    /**
     * 课程名称是否已经存在【true：存在；false：不存在】
     * @param cname 课程名称
     * @return
     * @author broken_xie
     */
    public boolean isCnameExist(String cname) {
        return 0 == courseDao.findByCname(cname).size() ? false : true;
    }
    
    /**
     * 分页查询课程集合
     * @param query 课程查询对象
     * @param currentPage 当前页码
     * @return
     * @author broken_xie
     */
    public Page<CourseResponse> findPageByQuery(CourseQuery query, int currentPage) {
        Page<CourseResponse> page = new Page<CourseResponse>(currentPage);
        return courseDao.findPageByQuery(query, page);
    }
    
    /**
     * 根据课程uuid查找课程【编辑、查看】
     * @param uuid 课程uuid
     * @return
     * @author broken_xie
     */
    public CourseResponse findForView(String uuid) {
        CourseResponse response = courseDao.findForView(uuid);
        return response;
    }
    
    /**
     * 启用/停用
     * @param uuid 课程uuid
     * @param cstatus 状态【0：停用；1：启用】
     * @param sessionContainer 登录会话容器
     * @author broken_xie
     */
    public void start(String uuid, String cstatus, SessionContainer sessionContainer) {
        TCourse c = courseDao.findByUuid(uuid);
        c.setDupdate(new Date());
        c.setUuserid(sessionContainer.getUser().getUuid());
        c.setCstatus(cstatus);
        courseDao.update(c);
    }
    
    /**
     * 查找热门课程
     * @return
     * @author broken_xie
     */
    public List<TCourse> findForHot() {
        return courseDao.findForHot();
    }
    
    /**
     * 开课
     * @param uuid 课程uuid
     * @param dbgnlession 开课起始时间
     * @return
     * @author broken_xie
     */
    @Transactional(rollbackFor = Exception.class)
    public void open(OpenCourseRequest openCourse, SessionContainer sessionContainer) {
        TCourse course = courseDao.findByUuid(openCourse.getUuid());
        course.setCopen("1");
        courseDao.update(course);
        TLession lession = new TLession();
        lession.setCobject("teacher");
        lession.setDcreate(new Date());
        lession.setDbgnlession(toDate(openCourse.getDbgnlession()));
        lession.setDendlession(toDate(openCourse.getDendlession()));
        lession.setCtime(openCourse.getCperiod() + " " + openCourse.getCbgntime() + "-" + openCourse.getCendtime());
        lession.setDupdate(lession.getDcreate());
        lession.setUcourseid(openCourse.getUuid());
        lession.setUteacherid(sessionContainer.getUser().getUuid());
        lession.setUuid(getUUID());
        lession.setUuserid(sessionContainer.getUser().getUuid());
        lessionDao.save(lession);
    }
}
