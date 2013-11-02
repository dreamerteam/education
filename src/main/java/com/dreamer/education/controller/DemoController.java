package com.dreamer.education.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.po.TCourseType;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.dao.TUserDao;
import com.google.gson.Gson;

/**
 * Demo控制器
 * @since 2013-10-16 下午5:00:42
 * @author broken_xie
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
    private TUserDao userDao;
    
    @RequestMapping("/test2")
    @ResponseBody
    public TUser test2(){
        return userDao.findByClogin("manager");
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        TCourseType type1 = new TCourseType();
        type1.setCname("文学类1");
        TCourseType type2 = new TCourseType();
        type2.setCname("文学类2");
        TCourseType type3 = new TCourseType();
        type3.setCname("文学类3");
        // type1.setTcourseType(type2);
        // type2.setTcourseType(type3);
        
        TCourseType type11 = new TCourseType();
        type11.setCname("文学类11");
        TCourseType type22 = new TCourseType();
        type22.setCname("文学类22");
        TCourseType type33 = new TCourseType();
        type33.setCname("文学类33");
        // type11.setTcourseType(type22);
        // type22.setTcourseType(type33);
        
        List<Object> list = new ArrayList<Object>();
        list.add("文2");
        list.add(type1);
        list.add(type11);
        list.add("文");
        
        /*
         * type1.setTCourses(set1); TUser user = new TUser(); user.setCname("s"); user.setUuid("s1"); Set<TUserAuthority> set = new HashSet<TUserAuthority>(); TUserAuthority userAuthority = new TUserAuthority(); userAuthority.setUuid("s3"); set.add(userAuthority); user.setTuserAuthorities(set);
         */
        return new Gson().toJson(list);
    }
}
