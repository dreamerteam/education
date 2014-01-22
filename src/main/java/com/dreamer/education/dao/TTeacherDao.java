package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.ro.TeacherResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

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
    
    /**
     * 查找热门教师
     * @return
     * @author broken_xie
     */
    public List<TTeacher> findForHot() {
        String sql = "SELECT * from t_teacher LIMIT 20";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TTeacher>(TTeacher.class));
    }
    
    /**
     * 获取最大教师编号
     * @return
     * @author broken_xie
     */
    public String findMaxCno() {
        String sql = "SELECT cno FROM t_teacher ORDER BY cno DESC LIMIT 1";
//        return getJdbcTemplate().queryForObject(sql, (Map<String, Object>) new HashMap<String, Object>(), String.class);
        List<String> list = getJdbcTemplate().queryForList(sql, (Map<String, Object>)new HashMap<String, Object>(), String.class);
        return list.isEmpty() ?null:list.get(0);
    }
    
    /**
     * 分页查询教师集合
     * @param page 分页工具类
     * @return
     * @author broken_xie
     */
    public Page<TeacherResponse> findPageByQuery(Page<TeacherResponse> page) {
        StringBuilder sql = new StringBuilder(" SELECT t.uuid, t.ccountry, t.ceducation, t.cmobile, t.cname, t.cnativeplace, t.cno, t.cqq, t.csex, t.dupdate ");
        sql.append(" from t_teacher t ORDER BY t.dupdate DESC ");
        Map<String, Object> map = new HashMap<String, Object>();
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, TeacherResponse.class);
    }
    
    /**
     * 根据教师uuid查找教师【查看】
     * @param uuid 教师uuid
     * @return
     * @author broken_xie
     */
    public TTeacher findForView(String uuid) {
        String sql = "select * from t_teacher where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TTeacher> teachers = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TTeacher>(TTeacher.class));
        return teachers.isEmpty() ? null : teachers.get(0);
    }
}
