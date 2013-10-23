package com.dreamer.education.dao.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dreamer.education.po.mapper.DomainMapper;

/**
 * 数据访问基类【所有数据访问接口需要继承此类】
 * @since 2013-10-18 下午2:12:45
 * @author broken_xie
 */
public class BaseDao<T> {
    
    /** 日志 */
    protected Logger logger = Logger.getLogger("com.dreamer.education.dao.base.BaseDao");
    
    /** jdbc操作模板 */
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    /** 保存操作 */
    private static final String INSERT = "insert";
    
    /** 更新操作 */
    private static final String UPDATE = "update";
    
    /** 删除操作 */
    private static final String DELETE = "delete";
    
    /** 序列化版本UID */
    private static final String SERIALVERSIONUID = "serialVersionUID";
    
    /** 类对象 */
    private Class<T> entityClass;
    
    /**
     * 构造函数【获取entityClass】
     * @author broken_xie
     */
    @SuppressWarnings("unchecked")
    public BaseDao() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) type.getActualTypeArguments()[0];
    }
    
    /**
     * 获取 jdbc操作模板
     * @return jdbcTemplate
     */
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    public int save(T entity) {
        String sql = generateSql(entity, INSERT);
        Map<String, Object> paramMap = setParam(entity, INSERT);
        return jdbcTemplate.update(sql, paramMap);
    }
    
    /**
     * 根据操作类型自动生成sql
     * @param operate 操作类型
     * @return
     * @author broken_xie
     */
    private String generateSql(T entity, String operate) {
        StringBuffer sql = new StringBuffer();
        Field[] fields = entityClass.getDeclaredFields(); // 获取类的属性
        try {
            DomainMapper domainMapper = new DomainMapper();
            domainMapper.load(entity.getClass());
            String tableName = domainMapper.getTableName();
            switch (operate) {
                case INSERT:
                    sql.append(" INSERT INTO " + tableName);
                    sql.append(" ( ");
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (SERIALVERSIONUID.equals(field.getName())) {
                            continue;
                        }
                        sql.append(field.getName()).append(",");
                    }
                    sql = sql.deleteCharAt(sql.length() - 1);
                    sql.append(" ) VALUES ( ");
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (SERIALVERSIONUID.equals(field.getName())) {
                            continue;
                        }
                        sql.append(":").append(field.getName()).append(",");
                    }
                    sql = sql.deleteCharAt(sql.length() - 1);
                    sql.append(" ) ");
                    break;
                case UPDATE:
                    sql.append(" UPDATE " + tableName + " SET ");
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (SERIALVERSIONUID.equals(field.getName())) {
                            continue;
                        }
                        if ("uuid".equals(field.getName())) {
                            continue;
                        }
                        if (null == field.get(entity)) {
                            continue;
                        }
                        sql.append(field.getName()).append("=").append(":").append(field.getName()).append(",");
                    }
                    sql = sql.deleteCharAt(sql.length() - 1);
                    sql.append(" WHERE uuid=:uuid");
                    break;
                case DELETE:
                    sql.append(" DELETE FROM " + tableName + " WHERE uuid=:uuid");
                    break;
                
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        logger.info("SQL = " + sql);
        return sql.toString();
    }
    
    /**
     * 设置参数
     * @param entity 实体类
     * @param operate 操作类型
     * @return
     * @author broken_xie
     */
    private Map<String, Object> setParam(T entity, String operate) {
        Field[] fields = entityClass.getDeclaredFields();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        try {
            switch (operate) {
                case INSERT:
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (SERIALVERSIONUID.equals(field.getName())) {
                            continue;
                        }
                        paramMap.put(field.getName(), field.get(entity));
                    }
                    break;
                case UPDATE:
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (SERIALVERSIONUID.equals(field.getName())) {
                            continue;
                        }
                        if (null == field.get(entity)) {
                            continue;
                        }
                        paramMap.put(field.getName(), field.get(entity));
                    }
                    break;
                case DELETE:
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if ("uuid".equals(field.getName())) {
                            paramMap.put(field.getName(), field.get(entity));
                            break;
                        }
                    }
                    break;
                
                default:
                    break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logger.error(e);
        }
        logger.info("SQL_PARAM = " + paramMap);
        return paramMap;
    }
    
}
