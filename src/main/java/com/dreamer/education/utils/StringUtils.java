package com.dreamer.education.utils;

import static com.dreamer.education.utils.ValidateUtils.isInteger;

import java.util.Random;
import java.util.UUID;

/**
 * 工具类【字符串处理】
 * @since 2013-10-21 下午1:52:08
 * @author broken_xie
 */
public class StringUtils {
    
    /**
     * 生成uuid
     * @return
     * @author broken_xie
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * 获取默认字符串（如果字符串为null，返回空字符串，否则返回去掉前后空格的字符串）
     * @param value 字符串
     * @return
     * @author broken_xie
     */
    public static String defaultString(String str) {
        return null == str ? "" : str.trim();
    }
    
    /**
     * 获取字符串字节长度（兼容oracle）【oracle一个中文字符等于三个字节】
     * @param str 字符串
     * @param repLen
     * @return
     * @author broken_xie
     */
    public static int bytesLength(String str) {
        return null == str ? 0 : str.replaceAll("[^\\x00-\\xff]", "***").length();
    }
    
    /**
     * 生成随机码
     * @param str 随机字符
     * @param length 随机码长度
     * @return
     * @author broken_xie
     */
    public static String randomString(String str, int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(str.charAt(random.nextInt(str.length())));
        }
        return result.toString();
    }
    
    /**
     * 生成随机码
     * @param length 随机码长度
     * @return
     * @author broken_xie
     */
    public static String randomString(int length) {
        return randomString("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", length);
    }
    
    /**
     * 将字符串转换成unicode编码，同native2ascii转换效果
     * @param str 原始字符串
     * @return
     * @author broken_xie
     */
    public static String toUnicode(String str) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch > 128) {
                buffer.append("\\u");
                buffer.append(Integer.toHexString(ch));
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }
    
    /**
     * 字符串转整数
     * @param str 需要转换的字符串
     * @return
     * @author broken_xie
     */
    public static int str2int(String str) {
        if (isInteger(str)) return Integer.valueOf(str);
        return 0;
    }
}
