package com.dreamer.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.dao.TCourseTypeDao;
import com.google.gson.Gson;

/**
 * 数据下拉 业务访问接口
 * @since 2013-10-17 下午1:15:25
 * @author broken_xie
 */
@Service
public class AutoCompleteService {
    
    /** 课程类型数据访问接口 */
    @Autowired
    private TCourseTypeDao courseTypeDao;
    
    /**
     * 根据类型获取数据
     * @param type 类型
     * @return
     * @author broken_xie
     */
    public String getData(String type) {
        Gson gson = new Gson();
        String data = "";
        switch (type) {
            case "courseType": // 获取课程类型
                data = "var " + type + " = " + gson.toJson(courseTypeDao.findForAutoComplete()) + ";";
                break;
            
            default:
                break;
        }
        return data;
    }
    
    /**
     * 设置等级
     * @param label 标签值
     * @param ilevel 等级
     * @return
     * @author broken_xie
     */
    public String addSpace(int ilevel) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < ilevel; i++) {
            space.append("  ");
        }
        return space.toString();
    }
}
