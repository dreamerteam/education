package com.dreamer.education.dao;

import static com.dreamer.education.utils.StringUtils.defaultString;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

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
     * @return
     * @author broken_xie
     */
    public Page<LessionResponse> findPageByQuery(LessionQuery query, Page<LessionResponse> page) {
        StringBuilder sql = new StringBuilder("SELECT tl.uuid, tl.dlession, tc.cname as ccoursename, tc.ihot, tc.ckeyword, tct.cname as ctypename ");
        sql.append(" FROM t_course tc, t_lession tl, t_course_type tct");
        sql.append(" WHERE tc.uuid = tl.ucourseid ");
        sql.append(" AND tc.utypeid = tct.uuid ");
        sql.append(" and tc.copen = :copen ");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("copen", "1");
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, LessionResponse.class);
    }
}
