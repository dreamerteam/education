package com.dreamer.education.dao;

import static com.dreamer.education.utils.StringUtils.defaultString;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.qo.CourseQuery;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

/**
 * 课程数据访问接口
 * @since 2013-11-4 上午10:44:51
 * @author broken_xie
 */
@Service
public class TCourseDao extends BaseDao<TCourse> {
    
    /**
     * 根据课程名称查找课程
     * @param cname 课程名称
     * @return
     * @author broken_xie
     */
    public List<TCourse> findByCname(String cname) {
        String sql = "select * from t_course where cname = :cname ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cname", cname);
        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TCourse>(TCourse.class));
    }
    
    /**
     * 分页查询课程集合
     * @param query 课程查询对象
     * @param page 分页工具类
     * @return
     * @author broken_xie
     */
    public Page<CourseResponse> findPageByQuery(CourseQuery query, Page<CourseResponse> page) {
        StringBuilder sql = new StringBuilder("SELECT tc.uuid, tc.cname, tc.cstatus ");
        sql.append(" , ihot, ckeyword, tct.cname as ctypename, tc.caudit, tc.copen ");
        sql.append(" FROM t_course tc LEFT JOIN t_course_type tct ");
        sql.append(" ON tc.utypeid = tct.uuid ");
        sql.append(" where 1 = 1 ");
        Map<String, Object> map = new HashMap<String, Object>();
        if (!isEmpty(query.getCname())) {
            sql.append(" and tc.cname like :cname ");
            map.put("cname", "%" + defaultString(query.getCname()) + "%");
        }
        if (!isEmpty(query.getCaudit())) {
            sql.append(" and tc.caudit = :caudit ");
            map.put("caudit", defaultString(query.getCaudit()));
        }
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, CourseResponse.class);
    }
    
    /**
     * 根据课程uuid查找课程【编辑、查看】
     * @param uuid 课程uuid
     * @return
     * @author broken_xie
     */
    public CourseResponse findForView(String uuid) {
        StringBuilder sql = new StringBuilder("SELECT tc.uuid, tc.cname, tc.cstatus, ihot, ckeyword, tct.cname as ctypename ");
        sql.append(" , tc.cdescription, tc.utypeid, tc.caudit ");
        sql.append(" FROM t_course tc LEFT JOIN t_course_type tct ");
        sql.append(" ON tc.utypeid = tct.uuid ");
        sql.append(" where tc.uuid = :uuid ");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<CourseResponse> responses = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<CourseResponse>(CourseResponse.class));
        return responses.isEmpty() ? null : responses.get(0);
    }
    
    /**
     * 根据uuid查找课程
     * @param uuid 课程uuid
     * @return
     * @author broken_xie
     */
    public TCourse findByUuid(String uuid) {
        String sql = "select * from t_course where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TCourse> courses = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TCourse>(TCourse.class));
        return courses.isEmpty() ? null : courses.get(0);
    }
    
    /**
     * 查找热门课程
     * @return
     * @author broken_xie
     */
    public List<TCourse> findForHot() {
        String sql = "SELECT * from t_course ORDER BY ihot DESC LIMIT 20";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TCourse>(TCourse.class));
    }
}
