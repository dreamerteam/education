package com.dreamer.education.po.mapper;

import org.apache.log4j.Logger;

import com.dreamer.education.annotation.TableMapper;

/**
 * 实体类映射
 * @since 2013-10-21 下午5:12:15
 * @author broken_xie
 */
public class DomainMapper {
    
    /** 日志 */
    protected Logger logger = Logger.getLogger("com.dreamer.education.po.mapper.DomainMapper");
    
    /** 数据库表名 */
    private String tableName;
    
    /**
     * 加载映射
     * @param entity
     * @author broken_xie
     */
    public void load(Class<?> entity) {
        TableMapper tableMapper = entity.getAnnotation(TableMapper.class);
        if (null == tableMapper) {
            logger.error("No TableMapper in class " + entity.getName());
        } else if (tableMapper.name().isEmpty()) {
            logger.error("No TableMapper in class " + entity.getName());
        } else {
            tableName = tableMapper.name(); // 获取表名
        }
    }
    
    /**
     * 获取 数据库表名
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }
    
}
