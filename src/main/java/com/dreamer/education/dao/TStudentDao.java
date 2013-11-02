package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.dao.base.BaseDao;

/**
 * 学生数据访问接口
 * @since 2013-10-29 上午10:10:40
 * @author broken_xie
 */
@Service
public class TStudentDao extends BaseDao<TStudent> {
    
    /**
     * 根据uuid查找学生信息
     * @param uuid 学生uuid
     * @return
     * @author broken_xie
     */
    public TStudent findByUuid(String uuid) {
        String sql = "select * from t_student where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        List<TStudent> students = getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TStudent>(TStudent.class));
        return students.isEmpty() ? null : students.get(0);
    }
}
