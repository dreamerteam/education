package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.dao.TUserDao;

/**
 * 用户业务访问接口
 * @since 2013-10-6 下午9:18:28
 * @author broken_xie
 */
@Service
public class TUserService {
    
    /** 用户数据访问接口 */
    @Autowired
    private TUserDao userDao;
    
    /**
     * 根据登录名获取用户信息
     * @param clogin 登录名
     * @return
     * @author broken_xie
     */
    public TUser findByClogin(String clogin) {
        return userDao.findByClogin(clogin);
    }
}
