package com.dreamer.education.dao;

import static com.dreamer.education.utils.StringUtils.defaultString;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.po.TResource;
import com.dreamer.education.bean.qo.ResourceQuery;
import com.dreamer.education.bean.ro.ResourceResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

/**
 * 资源数据访问接口
 * @since 2013-11-14 下午4:36:50
 * @author broken_xie
 */
@Service
public class TResourceDao extends BaseDao<TResource> {
    
    /**
     * 根据资源名称查找资源信息
     * @param cname 资源名称
     * @return
     * @author broken_xie
     */
    public List<TResource> findByCname(String cname) {
        String sql = "select * from t_resource where cname = :cname ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cname", cname);
        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TResource>(TResource.class));
    }
    
    /**
     * 分页查询资源集合
     * @param query 资源查询对象
     * @param page 分页工具类
     * @return
     * @author broken_xie
     */
    public Page<ResourceResponse> findPageByQuery(ResourceQuery query, Page<ResourceResponse> page) {
        StringBuilder sql = new StringBuilder("SELECT r.uuid, r.cname, r.ctype, r.dcreate, r.ckeyword, r.cfree, r.cpictureurl, r.cdescription  FROM t_resource r");
        sql.append(" where 1 = 1 ");
        Map<String, Object> map = new HashMap<String, Object>();
        if (!isEmpty(query.getCname())) {
            sql.append(" and r.cname like :cname ");
            map.put("cname", "%" + defaultString(query.getCname()) + "%");
        }
        if (!isEmpty(query.getCfree())) {
            sql.append(" and r.cfree = :cfree ");
            map.put("cfree", defaultString(query.getCfree()));
        }
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        return getPage(sql, map, page, ResourceResponse.class);
    }
    
    /**
     * 根据uuid查找资源
     * @param uuid 资源uuid
     * @return
     * @author broken_xie
     */
    public TResource findByUuid(String uuid) {
        String sql = "select * from t_resource where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + map);
        List<TResource> resources = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TResource>(TResource.class));
        return resources.isEmpty() ? null : resources.get(0);
    }
    
    /**
     * 查找免费资源
     * @return
     * @author broken_xie
     */
    public List<TResource> findForFree() {
        String sql = "select * from t_resource where cfree = '1' LIMIT 20";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TResource>(TResource.class));
    }
}
