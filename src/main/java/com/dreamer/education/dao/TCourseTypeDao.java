package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.AutoComplete;
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
    public List<AutoComplete> findForAutoComplete() {
        String sql = "select uuid as value, cname as label, ilevel from t_course_type";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<AutoComplete>(AutoComplete.class));
    }
    
    /**
     * 查找所有的课程类型列表
     * @return
     * @author broken_xie
     */
    public List<TCourseType> findAll() {
        String sql = "select * from t_course_type";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
    }
    
    /**
     * 根据课程类型名称查找课程类型
     * @param cname 课程类型名称
     * @return
     * @author broken_xie
     */
    public List<TCourseType> findByCname(String cname) {
        String sql = "select * from t_course_type where cname = :cname";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cname", cname);
        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
    }
    
}
