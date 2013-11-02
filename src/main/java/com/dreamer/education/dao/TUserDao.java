package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.dao.base.BaseDao;

/**
 * 用户数据访问接口
 * @since 2013-10-29 上午10:10:40
 * @author broken_xie
 */
@Service
public class TUserDao extends BaseDao<TUser> {
    
    /**
     * 根据登录名查找用户信息
     * @param clogin 登录名
     * @return
     * @author broken_xie
     */
    public TUser findByClogin(String clogin) {
        String sql = "select * from t_user where clogin = :clogin";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("clogin", clogin);
        List<TUser> users = getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TUser>(TUser.class));
        return users.isEmpty() ? null : users.get(0);
    }
}
