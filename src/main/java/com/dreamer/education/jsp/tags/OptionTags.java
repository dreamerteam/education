package com.dreamer.education.jsp.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 下拉Option
 * @since 2013-11-20 下午4:00:00
 * @author broken_xie
 */
public class OptionTags extends TagSupport {
    
    /**  */
    private static final long serialVersionUID = -5054606044746601212L;
    
    /** 下拉类型 */
    private String option;
    
    /** 参数 */
    private String param;
    
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(getOptionList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    
    /**
     * 获取Option列表
     * @return
     * @author broken_xie
     */
    private String getOptionList() {
        StringBuilder options = new StringBuilder();
        switch (option) {
            case "period": // 时间间隔
                List<String> periods = new ArrayList<String>();
                periods.add("每天");
                periods.add("周末");
                periods.add("周一至周五");
                periods.add("周一");
                periods.add("周二");
                periods.add("周三");
                periods.add("周四");
                periods.add("周五");
                periods.add("周六");
                periods.add("周日");
                for (String per : periods) {
                    options.append("<option value=\"" + per + "\">" + per + "</option>");
                }
                break;
            default:
                break;
        }
        return options.toString();
    }
    
    /**
     * 获取 下拉类型
     * @return option
     */
    public String getOption() {
        return option;
    }
    
    /**
     * 设置 下拉类型
     * @param option 下拉类型
     */
    public void setOption(String option) {
        this.option = option;
    }
    
    /**
     * 获取 参数
     * @return param
     */
    public String getParam() {
        return param;
    }
    
    /**
     * 设置 参数
     * @param param 参数
     */
    public void setParam(String param) {
        this.param = param;
    }
    
}
