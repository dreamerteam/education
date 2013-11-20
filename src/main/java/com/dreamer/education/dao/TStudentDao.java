package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TStudent;
import com.dreamer.education.bean.ro.StudentResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

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
    
    /**
     * 分页查询学生集合
     * @param page 分页工具类
     * @return
     * @author broken_xie
     */
    public Page<StudentResponse> findPageByQuery(Page<StudentResponse> page) {
        StringBuilder sql = new StringBuilder(" SELECT t.uuid, t.ccountry, t.ceducation, t.cmobile, t.cname, t.cnativeplace, t.cno, t.cqq, t.csex, t.dupdate ");
        sql.append(" from t_student t ORDER BY t.dupdate DESC ");
        Map<String, Object> map = new HashMap<String, Object>();
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, StudentResponse.class);
    }
    
    /**
     * 根据学生uuid查找学生【查看】
     * @param uuid 学生uuid
     * @return
     * @author broken_xie
     */
    public TStudent findForView(String uuid) {
        String sql = "select * from t_student where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TStudent> students = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TStudent>(TStudent.class));
        return students.isEmpty() ? null : students.get(0);
    }
}
