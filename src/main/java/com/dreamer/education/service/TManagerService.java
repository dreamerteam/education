package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.dao.TManagerDao;

/**
 * 管理员业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TManagerService {
    
    /** 管理员数据访问接口 */
    @Autowired
    private TManagerDao managerDao;
    
    /**
     * 根据uuid查找管理员信息
     * @param uuid 管理员uuid
     * @return
     * @author broken_xie
     */
    public TManager findByUuid(String uuid) {
        return managerDao.findByUuid(uuid);
    }
    
}
