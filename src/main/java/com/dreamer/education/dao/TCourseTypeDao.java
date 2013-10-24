package com.dreamer.education.dao;

import static com.dreamer.education.utils.StringUtils.defaultString;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.AutoComplete;
import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

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
        String sql = "select uuid as value, cname as label, ilevel, ccode from t_course_type where cstatus <> '0' order by ccode";
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
        String sql = "select * from t_course_type where cname = :cname and cstatus <> '0' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cname", cname);
        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
    }
    
    /**
     * 根据课程类型代码查找课程类型
     * @param ccode 课程类型代码
     * @return
     * @author broken_xie
     */
    public List<TCourseType> findByCcode(String ccode) {
        String sql = "select * from t_course_type where ccode = :ccode and cstatus <> '0' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ccode", ccode);
        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
    }
    
    /**
     * 分页查询课程类型集合
     * @param cname 课程类型名称
     * @param page 分页工具类
     * @return
     * @author broken_xie
     */
    public Page<TCourseType> findPageByQuery(String cname, Page<TCourseType> page) {
        StringBuilder sql = new StringBuilder("select * from t_course_type where cstatus <> '0' ");
        Map<String, Object> map = new HashMap<String, Object>();
        if (!isEmpty(cname)) {
            sql.append(" and cname like :cname ");
            map.put("cname", "%" + defaultString(cname) + "%");
        }
        return getPage(sql, map, page, TCourseType.class);
    }
    
    public TCourseType findByUuid(String uuid) {
        String sql = "select * from t_course_type where uuid = :uuid";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", uuid);
        List<TCourseType> courseTypes = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TCourseType>(TCourseType.class));
        return courseTypes.isEmpty() ? null : courseTypes.get(0);
    }
}
