package com.dreamer.education.jsp.tags;

import java.util.HashMap;
import java.util.Map;

/**
 * key/value转换标签
 * @since 2013-11-14 下午2:05:43
 * @author broken_xie
 */
public class FunctionTags {
    
    /** Map存储key/value */
    private static Map<String, String> convertMap = new HashMap<String, String>();
    
    /** 用户状态【0：未启用】 */
    private static final String USER_STATUS_0 = "未启用";
    
    /** 用户状态【1：启用】 */
    private static final String USER_STATUS_1 = "启用";
    
    /** 课程状态【0：未启用】 */
    private static final String COURSE_STATUS_0 = "未启用";
    
    /** 课程状态【1：启用】 */
    private static final String COURSE_STATUS_1 = "启用";
    
    /** 课程审核状态【0：未审核】 */
    private static final String COURSE_AUDIT_0 = "未审核";
    
    /** 课程审核状态【10：待审核】 */
    private static final String COURSE_AUDIT_10 = "待审核";
    
    /** 课程审核状态【20：通过审核】 */
    private static final String COURSE_AUDIT_20 = "通过审核";
    
    /** 课程审核状态【30：未通过审核】 */
    private static final String COURSE_AUDIT_30 = "未通过审核";
    
    /** 免费状态【0：非免费】 */
    private static final String FREE_0 = "非免费";
    
    /** 免费状态【1：免费】 */
    private static final String FREE_1 = "免费";
    
    /** 开课状态【0：待开课；1：开课】 */
    private static final String OPEN_0 = "待开课";
    
    /** 开课状态【0：待开课；1：开课】 */
    private static final String OPEN_1 = "开课";
    
    static {
        convertMap.put("user_status_0", USER_STATUS_0);
        convertMap.put("user_status_1", USER_STATUS_1);
        convertMap.put("course_status_0", COURSE_STATUS_0);
        convertMap.put("course_status_1", COURSE_STATUS_1);
        convertMap.put("course_audit_0", COURSE_AUDIT_0);
        convertMap.put("course_audit_10", COURSE_AUDIT_10);
        convertMap.put("course_audit_20", COURSE_AUDIT_20);
        convertMap.put("course_audit_30", COURSE_AUDIT_30);
        convertMap.put("free_0", FREE_0);
        convertMap.put("free_1", FREE_1);
        convertMap.put("open_0", OPEN_0);
        convertMap.put("open_1", OPEN_1);
    }
    
    /**
     * 根据类型状态key值，返回对应的value
     * @param type 类型
     * @param key 状态值
     * @return
     * @author broken_xie
     */
    public static String convert(String type, String key) {
        return convertMap.get((type + "_" + key).toLowerCase());
    }
    
    /**
     * 截取字符串
     * @param src 需要被截取的源字符串
     * @param length 截取长度
     * @return
     * @author broken_xie
     */
    public static String cut(String src, int length) {
        return src.length() > length ? src.substring(0, length) + "...." : src;
    }
}
