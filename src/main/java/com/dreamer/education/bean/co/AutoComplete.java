package com.dreamer.education.bean.co;

import java.io.Serializable;

/**
 * @since 2013-10-23 下午5:34:24
 * @author broken_xie
 */
public class AutoComplete implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -7652585738832172913L;
    
    /** 标签值 */
    private String label;
    
    /** 实际值 */
    private String value;
    
    /** 等级【下标从0开始】 */
    private int ilevel;
    
    /** 代码 */
    private String ccode;
    
    /** 拼音 */
    private String pinyin;
    
    /**
     * 获取 标签值
     * @return label
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * 设置 标签值
     * @param label 标签值
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * 获取 实际值
     * @return value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * 设置 实际值
     * @param value 实际值
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * 获取 等级【下标从0开始】
     * @return ilevel
     */
    public int getIlevel() {
        return ilevel;
    }
    
    /**
     * 设置 等级【下标从0开始】
     * @param ilevel 等级【下标从0开始】
     */
    public void setIlevel(int ilevel) {
        this.ilevel = ilevel;
    }
    
    /**
     * 获取 代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 代码
     * @param ccode 代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 拼音
     * @return pinyin
     */
    public String getPinyin() {
        return pinyin;
    }
    
    /**
     * 设置 拼音
     * @param pinyin 拼音
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    
}
