package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 资源查询对象
 * @since 2013-11-15 下午1:45:31
 * @author broken_xie
 */
public class ResourceQuery implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 8310294545129657540L;
    
    /** 资源名称 */
    private String cname;
    
    /** 免费【0:不免费；1：免费】 */
    private String cfree;
    
    /**
     * 获取 免费【0:不免费；1：免费】
     * @return cfree
     */
    public String getCfree() {
        return cfree;
    }
    
    /**
     * 设置 免费【0:不免费；1：免费】
     * @param cfree 免费【0:不免费；1：免费】
     */
    public void setCfree(String cfree) {
        this.cfree = cfree;
    }
    
    /**
     * 获取 资源名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 资源名称
     * @param cname 资源名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
}
