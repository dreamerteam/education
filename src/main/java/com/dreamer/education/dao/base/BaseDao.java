package com.dreamer.education.dao.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dreamer.education.po.mapper.DomainMapper;
import com.dreamer.education.utils.Page;

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
    
    /** 物理删除操作 */
    private static final String PHYSICAL_DELETE = "physical_delete";
    
    /** 逻辑删除操作 */
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
    
    /**
     * 保存
     * @param entity 实体类
     * @return
     * @author broken_xie
     */
    public int save(T entity) {
        String sql = generateSql(entity, INSERT);
        Map<String, Object> paramMap = setParam(entity, INSERT);
        return jdbcTemplate.update(sql, paramMap);
    }
    
    /**
     * 更新
     * @param entity 实体类
     * @return
     * @author broken_xie
     */
    public int update(T entity) {
        String sql = generateSql(entity, UPDATE);
        Map<String, Object> paramMap = setParam(entity, UPDATE);
        return jdbcTemplate.update(sql, paramMap);
    }
    
    /**
     * 删除
     * @param entity 实体类
     * @param isPhysicalDel 是否物理删除【true：物理删除；false：逻辑删除】
     * @return
     * @author broken_xie
     */
    public int delete(T entity, boolean isPhysicalDel) {
        String sql = "";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (isPhysicalDel) {
            sql = generateSql(entity, PHYSICAL_DELETE);
            paramMap = setParam(entity, PHYSICAL_DELETE);
        } else {
            sql = generateSql(entity, DELETE);
            paramMap = setParam(entity, DELETE);
        }
        return jdbcTemplate.update(sql, paramMap);
    }
    
    /**
     * 逻辑删除
     * @param entity 实体类
     * @return
     * @author broken_xie
     */
    public int delete(T entity) {
        return delete(entity, false);
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
                        /*
                         * if (null == field.get(entity)) { continue; }
                         */
                        sql.append(field.getName()).append("=").append(":").append(field.getName()).append(",");
                    }
                    sql = sql.deleteCharAt(sql.length() - 1);
                    sql.append(" WHERE uuid=:uuid");
                    break;
                case PHYSICAL_DELETE:
                    sql.append(" DELETE FROM " + tableName + " WHERE uuid = :uuid");
                    break;
                case DELETE:
                    sql.append(" UPDATE " + tableName + " SET cstatus = '0' WHERE uuid = :uuid");
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
                        /*
                         * if (null == field.get(entity)) { continue; }
                         */
                        paramMap.put(field.getName(), field.get(entity));
                    }
                    break;
                case PHYSICAL_DELETE:
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if ("uuid".equals(field.getName())) {
                            paramMap.put(field.getName(), field.get(entity));
                            break;
                        }
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
    
    /**
     * 分页查询方法【自动统计总记录数和查询结果集】
     * @param sql 查询语句
     * @param paramMap map参数
     * @param page 分页工具类
     * @param domain 实体类
     * @return
     * @author broken_xie
     */
    public <M extends Serializable> Page<M> getPage(CharSequence sql, Map<String, Object> paramMap, Page<M> page, Class<M> domain) {
        page.setTotalRow(getTotalCount(sql, paramMap));
        page.setResultRows(getPage(sql, paramMap, page.getStartRow(), page.getPageSize(), domain));
        return page;
    }
    
    /**
     * MySQL 分页查询
     * @param sql 查询语句
     * @param paramMap map参数
     * @param startRow 当前页在数据库中的起始行
     * @param pageSize 每页显示的记录数
     * @param domain 实体类
     * @return
     * @author broken_xie
     */
    public <M extends Serializable> List<M> getPage(CharSequence sql, Map<String, Object> paramMap, int startRow, int pageSize, Class<M> domain) {
        if (null == paramMap) paramMap = new HashMap<String, Object>();
        StringBuilder pagingSQL = new StringBuilder(sql.length() + 30);
        pagingSQL.append(sql);
        if (startRow > 0) {
            pagingSQL.append(" LIMIT :startRow, :pageSize");
            paramMap.put("startRow", startRow);
        } else {
            pagingSQL.append(" LIMIT :pageSize");
        }
        paramMap.put("pageSize", pageSize);
        logger.info("SQL = " + pagingSQL);
        logger.info("SQL_PARAM = " + paramMap);
        return getJdbcTemplate().query(pagingSQL.toString(), paramMap, new BeanPropertyRowMapper<M>(domain));
    }
    
    /**
     * 根据查询语句自动查询分页记录总数
     * @param sql 查询语句
     * @param paramMap map参数
     * @return
     * @author broken_xie
     */
    private Integer getTotalCount(CharSequence sql, Map<String, Object> paramMap) {
        // 代码逻辑思路：
        // 1. 从第一个SELECT开始往后匹配到对应的FROM位置，并截断（匹配思路：检查SELECT后面所有成对以及嵌套一层子查询的SELECT/FROM直到第一个不成对的FROM为止）
        // 2. 如果有，则去除主查询中末尾的ORDER BY
        // 3. 在截断后的语句前加上SELECT COUNT(1) 的内容拼成查询分页总记录数的语句
        
        Integer count = 0; // 记录总数
        Integer fromIndex = 0; // 主查询的FROM关键字的起始位置变量
        // 匹配主查询SELECT后面所有成对以及嵌套一层子查询的SELECT/FROM直到第一个单独出现的FROM为止
        // ((.(?!\\bSELECT\\b|\\bFROM\\b))*.\\bSELECT\\b(.(?!\\bFROM\\b))*.\\bFROM\\b(.(?!\\bSELECT\\b|\\bFROM\\b))*)* 此为一对SELECT/FROM的匹配规则
        Pattern fromPattern = Pattern.compile("^\\s*\\bSELECT\\b((.(?!\\bSELECT\\b|\\bFROM\\b))*.\\bSELECT\\b((.(?!\\bSELECT\\b|\\bFROM\\b))*.\\bSELECT\\b(.(?!\\bFROM\\b))*.\\bFROM\\b(.(?!\\bSELECT\\b|\\bFROM\\b))*)*(.(?!\\bFROM\\b))*.\\bFROM\\b((.(?!\\bSELECT\\b|\\bFROM\\b))*.\\bSELECT\\b(.(?!\\bFROM\\b))*.\\bFROM\\b(.(?!\\bSELECT\\b|\\bFROM\\b))*)*(.(?!\\bSELECT\\b|\\bFROM\\b))*)*(.(?!\\bFROM\\b))*",
                                              Pattern.CASE_INSENSITIVE);
        Matcher fromMatcher = fromPattern.matcher(sql);
        if (fromMatcher.find()) {
            // 加上被替换的内容长度，以及后面紧跟着主查询FROM的1个字符。因为最后一个字符是(.(?!\\bFROM\\b))
            fromIndex += fromMatcher.group().length() + 1;
            Pattern namedParamPattern = Pattern.compile(":[\\w\\-]+"); // 匹配预处理名字的编译器
            String prefixSQL = sql.toString().substring(0, fromIndex);
            String suffixSQL = sql.toString().substring(fromIndex);
            Matcher namedParamMatcher = namedParamPattern.matcher(prefixSQL);
            Map<String, Object> removeMap = new HashMap<>(); // 存储需要移除的预处理参数
            while (namedParamMatcher.find()) { // 查找仅在FROM前出现过的预处理名字参数，并从paramMap中移除
                if (!suffixSQL.matches(".*" + namedParamMatcher.group() + "\\b.*")) {
                    String key = namedParamMatcher.group().substring(1);
                    removeMap.put(key, paramMap.get(key));
                    paramMap.remove(key);
                }
            }
            // 去除主查询的ORDER BY。为简单处理，本处未考虑ORDER BY使用预处理参数的情况
            // 匹配主查询ORDER BY的编译器[规则：从ORDER BY到行尾中可含成对括号且不含后半个括号的内容，成对括号中支持最多嵌套3层括号]
            // (([^\\(\\)]*\\([^\\(\\)]*\\))*[^\\)]*)* 此为成对括号的正则，在其中，对其自身做了三次递归嵌套
            Pattern orderByPattern = Pattern.compile("\\bORDER\\s+BY\\b([^\\(\\)]*\\((([^\\(\\)]*\\((([^\\(\\)]*\\([^\\(\\)]*\\))*[^\\)]*)*\\))*[^\\)]*)*\\))*[^\\)]*$", Pattern.CASE_INSENSITIVE);
            Matcher orderByMatcher = orderByPattern.matcher(suffixSQL);
            if (orderByMatcher.find()) {
                suffixSQL = suffixSQL.substring(0, orderByMatcher.start());
            }
            count = getInt("SELECT COUNT(1) " + suffixSQL, paramMap);
            paramMap.putAll(removeMap); // 查询完成后，将移除的预处理参数重新置入paramMap，以免影响后面的列表查询
        } else {
            logger.error(new SQLException("缺失FROM关键字[" + sql + "]"));
        }
        return count;
    }
    
    /**
     * 查询整型字段<br>
     * 如查询count或sum
     * @param sql 查询语句
     * @param paramMap 参数Map
     * @return
     * @author broken_xie
     */
    @SuppressWarnings("deprecation")
    protected Integer getInt(CharSequence sql, Map<String, Object> paramMap) {
        logger.info("SQL = " + sql);
        logger.info("SQL_PARAM = " + paramMap);
        return getJdbcTemplate().queryForInt(sql.toString(), paramMap);
    }
    
}
