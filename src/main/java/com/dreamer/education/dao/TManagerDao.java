package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.dao.base.BaseDao;

/**
 * 管理员数据访问接口
 * @since 2013-10-29 上午10:10:40
 * @author broken_xie
 */
@Service
public class TManagerDao extends BaseDao<TManager> {
    
    /**
     * 根据uuid查找管理员信息
     * @param uuid 管理员uuid
     * @return
     * @author broken_xie
     */
    public TManager findByUuid(String uuid) {
        String sql = "select * from t_manager where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        List<TManager> managers = getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TManager>(TManager.class));
        return managers.isEmpty() ? null : managers.get(0);
    }
}
