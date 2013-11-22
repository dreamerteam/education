package com.dreamer.education.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TLession;
import com.dreamer.education.bean.qo.LessionQuery;
import com.dreamer.education.bean.ro.LessionResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

/**
 * 选课数据访问接口
 * @since 2013-11-19 下午1:51:58
 * @author broken_xie
 */
@Service
public class TLessionDao extends BaseDao<TLession> {
    
    /**
     * 分页查询选课集合
     * @param query 选课查询对象
     * @param page 分页工具类
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public Page<LessionResponse> findPageByQuery(LessionQuery query, Page<LessionResponse> page, SessionContainer sessionContainer) {
        StringBuilder sql = new StringBuilder("SELECT tl.uuid, tl.dbgnlession, tl.dendlession, tl.cperiod, tc.cname as ccoursename, tc.ihot, tc.ckeyword, tct.cname as ctypename ");
        sql.append(" FROM t_course tc, t_lession tl, t_course_type tct");
        sql.append(" WHERE tc.uuid = tl.ucourseid ");
        sql.append(" AND tc.utypeid = tct.uuid ");
        sql.append(" and tc.copen = :copen ");
        sql.append(" and tl.uuserid = :uuserid ");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("copen", "1");
        map.put("uuserid", sessionContainer.getUser().getUuid());
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, LessionResponse.class);
    }
    
    /**
     * 根据课程id和选课对象查找选课信息
     * @param ucourseid 课程id
     * @param cobject 选课对象
     * @return
     * @author broken_xie
     */
    public TLession findByUcourseidAndCobject(String ucourseid, String cobject) {
        String sql = "select * from t_lession where ucourseid = :ucourseid and cobject = :cobject";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ucourseid", ucourseid);
        map.put("cobject", cobject);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TLession> lessions = getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TLession>(TLession.class));
        return lessions.isEmpty() ? null : lessions.get(0);
    }
}
