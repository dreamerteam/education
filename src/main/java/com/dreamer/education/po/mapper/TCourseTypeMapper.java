package com.dreamer.education.po.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dreamer.education.bean.po.TCourseType;

/**
 * 课程类型 映射类
 * @since 2013-10-18 下午2:31:53
 * @author broken_xie
 */
public class TCourseTypeMapper implements RowMapper<TCourseType> {
    
    @Override
    public TCourseType mapRow(ResultSet rs, int rowNum) throws SQLException {
        TCourseType courseType = new TCourseType();
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            String columnName = metaData.getColumnName(i);
            switch (columnName) {
                case "cname":
                    courseType.setCname(rs.getString("cname"));
                    break;
                case "dcreate":
                    courseType.setDcreate(rs.getDate("dcreate"));
                    break;
                case "dupdate":
                    courseType.setDupdate(rs.getDate("dupdate"));
                    break;
                case "ilevel":
                    courseType.setIlevel(rs.getInt("ilevel"));
                    break;
                case "uparentid":
                    courseType.setUparentid(rs.getString("uparentid"));
                    break;
                case "uuid":
                    courseType.setUuid(rs.getString("uuid"));
                    break;
            }
        }
        return courseType;
    }
    
}
