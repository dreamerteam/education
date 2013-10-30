package com.dreamer.education.dao;

import static com.dreamer.education.utils.StringUtils.defaultString;
import static com.dreamer.education.utils.ValidateUtils.isEmpty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.AutoComplete;
import com.dreamer.education.bean.po.TCourse;
import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.bean.ro.CourseTypeResponse;
import com.dreamer.education.dao.base.BaseDao;
import com.dreamer.education.utils.Page;

/*
* @author Owen
* @version 创建时间：2013年10月28日 下午2:44:10 
*/ 
@Service
public class TCourseDao extends BaseDao<TCourse> {
    
	 public List<TCourse> findAll() {
	        String sql = "select * from t_course";
	        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<TCourse>(TCourse.class));
	    }
	 
	 public List<TCourse> findByCname(String cname) {
	        String sql = "select * from t_course where cname = :cname and cstatus <> '0' ";
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("cname", cname);
	        return getJdbcTemplate().query(sql, map, new BeanPropertyRowMapper<TCourse>(TCourse.class));
	    }
	    
	 public Page<TCourse> findPageByQuery(String cname, Page<TCourse> page) {
	        StringBuilder sql = new StringBuilder("select * from t_course where cstatus <> '0' ");
	        Map<String, Object> map = new HashMap<String, Object>();
	        if (!isEmpty(cname)) {
	            sql.append(" and cname like :cname ");
	            map.put("cname", "%" + defaultString(cname) + "%");
	        }
	        return getPage(sql, map, page, TCourse.class);
	    }
	    
	 public TCourse findByUuid(String uuid) {
	        String sql = "select * from t_course where uuid = :uuid";
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("uuid", uuid);
	        logger.info("SQL = " + sql);
	        logger.info("SQL_PARAM = " + map);
	        List<TCourse> courses = getJdbcTemplate().query(sql.toString(), map, new BeanPropertyRowMapper<TCourse>(TCourse.class));
	        return courses.isEmpty() ? null : courses.get(0);
	    }
	 
	 public int delete(String uuid) {
	        String sql = "update t_course set cstatus = '0' where uuid like :uuid";
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("uuid", uuid + "%");
	        return getJdbcTemplate().update(sql, map);
	 }
	   
	    
}
