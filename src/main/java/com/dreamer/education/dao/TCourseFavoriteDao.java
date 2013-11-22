package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TCourseFavorite;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

/**
 * 课程收藏数据访问接口
 * @since 2013-11-21 下午3:55:26
 * @author broken_xie
 */
@Service
public class TCourseFavoriteDao extends BaseDao<TCourseFavorite> {
    
    /**
     * 根据课程id和操作用户id查找课程收藏信息
     * @param ucourseid 课程id
     * @param uuserid 操作用户id
     * @return
     * @author broken_xie
     */
    public TCourseFavorite findByUcourseidAndUuserid(String ucourseid, String uuserid) {
        String sql = "select * from t_course_favorite where ucourseid = :ucourseid and uuserid = :uuserid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ucourseid", ucourseid);
        map.put("uuserid", uuserid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TCourseFavorite> favorites = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TCourseFavorite>(TCourseFavorite.class));
        return favorites.isEmpty() ? null : favorites.get(0);
    }
    
    /**
     * 分页查询课程收藏集合
     * @param page 分页工具类
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public Page<CourseResponse> findPageByQuery(Page<CourseResponse> page, SessionContainer sessionContainer) {
        StringBuilder sql = new StringBuilder("SELECT tc.uuid, tc.cname, ihot, tct.cname as ctypename, tc.copen ");
        sql.append(" , (SELECT tl.uuid from t_lession tl WHERE tl.ucourseid = tc.uuid and tl.uuserid = :uuserid) as ulessionid ");
        sql.append(" FROM t_course tc, t_course_type tct, t_course_favorite tcf ");
        sql.append(" WHERE tc.utypeid = tct.uuid ");
        sql.append(" and tc.uuid = tcf.ucourseid ");
        sql.append(" AND tcf.uuserid = :uuserid ");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuserid", sessionContainer.getUser().getUuid());
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, CourseResponse.class);
    }
}
