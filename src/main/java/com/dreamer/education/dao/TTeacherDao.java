package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.dao.base.BaseDao;

/**
 * 教师数据访问接口
 * @since 2013-10-29 上午10:10:40
 * @author broken_xie
 */
@Service
public class TTeacherDao extends BaseDao<TTeacher> {
    
    /**
     * 根据uuid查找教师信息
     * @param uuid 教师uuid
     * @return
     * @author broken_xie
     */
    public TTeacher findByUuid(String uuid) {
        String sql = "select * from t_teacher where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        List<TTeacher> teachers = getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TTeacher>(TTeacher.class));
        return teachers.isEmpty() ? null : teachers.get(0);
    }
}
