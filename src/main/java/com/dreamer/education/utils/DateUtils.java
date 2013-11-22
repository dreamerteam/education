package com.dreamer.education.utils;

import static com.dreamer.education.utils.ValidateUtils.isEmpty;
import static com.dreamer.education.utils.StringUtils.defaultString;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类【日期】
 * @since 2013-10-21 下午2:10:42
 * @author broken_xie
 */
public class DateUtils {
    
    /**
     * 字符串转日期【根据指定的格式化字符串格式化日期字符串】
     * @param date 日期字符串
     * @param pattern 格式化字符串
     * @return
     * @author broken_xie
     */
    public static Date toDate(String date, String pattern) {
        if (isEmpty(date)) return null;
        Date theDate;
        try {
            SimpleDateFormat theFormat = new SimpleDateFormat(pattern);
            theDate = theFormat.parse(date);
        } catch (Exception ex) {
            theDate = null;
        }
        return theDate;
    }
    
    /**
     * 字符串转日期【根据日期字符串类型格式化日期字符串】
     * @param date 日期字符串
     * @return
     * @author broken_xie
     */
    public static Date toDate(String date) {
        if ("".equals(defaultString(date))) {
            return null;
        }
        String separate = date.substring(4, 5);
        return toDate(date, "yyyy" + separate + "MM" + separate + "dd");
    }
    
    /**
     * 字符串转时间【根据时间字符串类型格式化时间字符串】
     * @param dateTime 时间字符串
     * @return
     * @author broken_xie
     */
    public static Date toDateTime(String dateTime) {
        String separate = dateTime.substring(4, 5);
        return toDate(dateTime, "yyyy" + separate + "MM" + separate + "dd HH:mm:ss");
    }
    
    /**
     * 日期转字符串【根据指定的格式化字符串格式化日期】
     * @param date 日期
     * @param pattern 格式化字符串
     * @return
     * @author broken_xie
     */
    public static String formatDate(Date date, String pattern) {
        if (null == pattern) throw new IllegalArgumentException("pattern不允许为空");
        if (null == date) return "";
        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        return fmt.format(date);
    }
    
    /**
     * 日期转字符串
     * @param date 日期
     * @return
     * @author broken_xie
     */
    public static String dateString(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }
    
    /**
     * 时间转字符串
     * @param dateTime 时间
     * @return
     * @author broken_xie
     */
    public static String dateTimeString(Date dateTime) {
        return formatDate(dateTime, "yyyy-MM-dd HH:mm:ss");
    }
}
