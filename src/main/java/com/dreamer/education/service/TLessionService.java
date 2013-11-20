package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @return
     * @author broken_xie
     */
    public Page<LessionResponse> findPageByQuery(LessionQuery query, int currentPage) {
        Page<LessionResponse> page = new Page<LessionResponse>(currentPage);
        return lessionDao.findPageByQuery(query, page);
    }
}
