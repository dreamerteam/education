package com.dreamer.education.bean.qo;

import java.io.Serializable;

/**
 * 课程类型查询对象
 * @since 2013-10-24 上午10:58:27
 * @author broken_xie
 */
public class CourseTypeQuery implements Serializable {
    
    /**  */
    private static final long serialVersionUID = -5784737582697090155L;
    
    /** 课程类型名称 */
    private String cname;
    
    /**
     * 获取 课程类型名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 课程类型名称
     * @param cname 课程类型名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
}
