package com.dreamer.education.bean.ro;

import java.io.Serializable;

/**
 * 开课请求对象
 * @since 2013-11-20 下午4:40:58
 * @author broken_xie
 */
public class OpenCourseRequest implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -2882262941705808399L;
    
    /** 课程uuid */
    private String uuid;
    
    /** 开课起始日期 */
    private String dbgnlession;
    
    /** 开课结束日期 */
    private String dendlession;
    
    /** 开课间隔时间【每天、周末、周一....】 */
    private String cperiod;
    
    /** 开课起始时间 */
    private String cbgntime;
    
    /** 开课结束时间 */
    private String cendtime;
    
    /**
     * 获取 课程uuid
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }
    
    /**
     * 设置 课程uuid
     * @param uuid 课程uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    /**
     * 获取 开课起始日期
     * @return dbgnlession
     */
    public String getDbgnlession() {
        return dbgnlession;
    }
    
    /**
     * 设置 开课起始日期
     * @param dbgnlession 开课起始日期
     */
    public void setDbgnlession(String dbgnlession) {
        this.dbgnlession = dbgnlession;
    }
    
    /**
     * 获取 开课结束日期
     * @return dendlession
     */
    public String getDendlession() {
        return dendlession;
    }
    
    /**
     * 设置 开课结束日期
     * @param dendlession 开课结束日期
     */
    public void setDendlession(String dendlession) {
        this.dendlession = dendlession;
    }
    
    /**
     * 获取 开课间隔时间【每天、周末、周一....】
     * @return cperiod
     */
    public String getCperiod() {
        return cperiod;
    }
    
    /**
     * 设置 开课间隔时间【每天、周末、周一....】
     * @param cperiod 开课间隔时间【每天、周末、周一....】
     */
    public void setCperiod(String cperiod) {
        this.cperiod = cperiod;
    }
    
    /**
     * 获取 开课起始时间
     * @return cbgntime
     */
    public String getCbgntime() {
        return cbgntime;
    }
    
    /**
     * 设置 开课起始时间
     * @param cbgntime 开课起始时间
     */
    public void setCbgntime(String cbgntime) {
        this.cbgntime = cbgntime;
    }
    
    /**
     * 获取 开课结束时间
     * @return cendtime
     */
    public String getCendtime() {
        return cendtime;
    }
    
    /**
     * 设置 开课结束时间
     * @param cendtime 开课结束时间
     */
    public void setCendtime(String cendtime) {
        this.cendtime = cendtime;
    }
    
}
