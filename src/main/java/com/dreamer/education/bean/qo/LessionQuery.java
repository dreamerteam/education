package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 选课查询对象
 * @since 2013-11-19 下午1:54:46
 * @author broken_xie
 */
public class LessionQuery implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 495250416121850867L;
    
    /** 是否开课【0：待开课；1：开课】 */
    private String copen;
    
    /**
     * 获取 是否开课【0：待开课；1：开课】
     * @return copen
     */
    public String getCopen() {
        return copen;
    }
    
    /**
     * 设置 是否开课【0：待开课；1：开课】
     * @param copen 是否开课【0：待开课；1：开课】
     */
    public void setCopen(String copen) {
        this.copen = copen;
    }
    
}
