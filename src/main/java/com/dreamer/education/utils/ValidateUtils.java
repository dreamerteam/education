package com.dreamer.education.utils;

import static com.dreamer.education.utils.StringUtils.defaultString;

/**
 * 工具类【验证】
 * @since 2013-10-21 下午1:41:23
 * @author broken_xie
 */
public class ValidateUtils {
    
    /**
     * 验证是否是邮箱
     * @param email 邮箱地址
     * @return
     * @author broken_xie
     */
    public static boolean isEmail(String email) {
        return null == email ? false : email.matches("^[\\w&&[^_]]+([\\.\\-_][\\w&&[^_]]+)*@([\\w&&[^_]]+[\\.\\-_]?)+[\\w&&[^_]]+\\.[A-Za-z]{2,5}$");
    }
    
    /**
     * 验证是否是手机号码
     * @param mobile 手机号码
     * @return
     * @author broken_xie
     */
    public static boolean isMobile(String mobile) {
        return null == mobile ? false : mobile.matches("^1[3458]\\d{9}$");
    }
    
    /**
     * 验证是否是正整数
     * @param str 字符串
     * @return
     * @author broken_xie
     */
    public static boolean isUInteger(String str) {
        return null == str ? false : str.matches("^\\d+");
    }
    
    /**
     * 验证是否是整数
     * @param str 字符串
     * @return
     * @author broken_xie
     */
    public static boolean isInteger(String str) {
        return null == str ? false : str.matches("^[-]?\\d+");
    }
    
    /**
     * 验证是否是正浮点数
     * @param str 字符串
     * @return
     * @author broken_xie
     */
    public static boolean isUFloat(String str) {
        return null == str ? false : str.matches("^\\d*(\\.\\d+)?");
    }
    
    /**
     * 验证是否是浮点数
     * @param str 字符串
     * @return
     * @author broken_xie
     */
    public static boolean isFloat(String str) {
        return null == str ? false : str.matches("^[-]?\\d*(\\.\\d+)?");
    }
    
    /**
     * 验证是否是UUID
     * @param uuid
     * @return
     * @author broken_xie
     */
    public static boolean isUUID(String uuid) {
        return null == uuid ? false : uuid.matches("^[\\w&&[^_]]{4}([\\w&&[^_]]{4}-){4}[\\w&&[^_]]{12}");
    }
    
    /**
     * 验证字符串是否是空【包括null和空字符串】
     * @param str
     * @param trim
     * @return
     * @author broken_xie
     */
    public static boolean isEmpty(String str) {
        return "".equals(defaultString(str)) ? true : false;
    }
}
