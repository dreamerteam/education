package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.dao.base.BaseDao;

/**
 * 课程类型 数据访问接口
 * @since 2013-10-18 下午2:33:49
 * @author broken_xie
 */
@Service
public class TCourseTypeDao extends BaseDao<TCourseType> {
    
    /**
     * 获取课程类型列表【用于自动下拉数据】
     * @return
     * @author broken_xie
     */
    public List<Map<String, Object>> findForAutoComplete() {
        String sql = "select uuid as value, cname as label from t_course_type";
        return getJdbcTemplate().queryForList(sql, new HashMap<String, Object>());
    }
    
    /**
     * 保存
     * @param courseType 课程类型
     * @return
     * @author broken_xie
     *//*
    public int save(TCourseType courseType) {
        String sql = "insert into t_course_type (uuid,cname,dcreate,dupdate,ilevel,uparentid,uuserid) values (:uuid,:cname,:dcreate,:dupdate,:ilevel,:uparentid,:uuserid)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", courseType.getUuid());
        map.put("cname", courseType.getCname());
        map.put("dcreate", courseType.getDcreate());
        map.put("dupdate", courseType.getDupdate());
        map.put("ilevel", courseType.getIlevel());
        map.put("uparentid", courseType.getUparentid());
        map.put("uuserid", courseType.getUuserid());
        return getJdbcTemplate().update(sql, map);
    }*/
    
    /**
     * 查找所有的课程类型列表
     * @return
     * @author broken_xie
     */
    public List<TCourseType> findAll(){
        String sql = "select * from t_course_type";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
    }
    
}
