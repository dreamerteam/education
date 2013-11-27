package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TLession;
import com.dreamer.education.bean.qo.LessionQuery;
import com.dreamer.education.bean.ro.LessionResponse;
import com.dreamer.education.dao.TLessionDao;
import com.dreamer.education.utils.Page;

/**
 * 选课业务访问接口
 * @since 2013-11-19 下午1:51:10
 * @author broken_xie
 */
@Service
public class TLessionService {
    
    /** 选课数据访问接口 */
    @Autowired
    private TLessionDao lessionDao;
    
    /**
     * 分页查询选课集合
     * @param query 选课查询对象
     * @param currentPage 当前页码
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public Page<LessionResponse> findPageByQuery(LessionQuery query, int currentPage, SessionContainer sessionContainer) {
        Page<LessionResponse> page = new Page<LessionResponse>(currentPage);
        return lessionDao.findPageByQuery(query, page, sessionContainer);
    }
    
    /**
     * 选课
     * @param ucourseid 课程id
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public void select(String ucourseid, SessionContainer sessionContainer) {
        TLession lession = lessionDao.findByUcourseidAndCobject(ucourseid, "teacher");
        TLession l = new TLession();
        l.setCobject("student");
        l.setCtime(lession.getCtime());
        l.setDbgnlession(lession.getDbgnlession());
        l.setDcreate(new Date());
        l.setDendlession(lession.getDendlession());
        l.setDupdate(l.getDcreate());
        l.setUcourseid(ucourseid);
        l.setUstudentid(sessionContainer.getUser().getUuid());
        l.setUuid(getUUID());
        l.setUuserid(sessionContainer.getUser().getUuid());
        lessionDao.save(l);
    }
}
