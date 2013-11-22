package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TCourseFavorite;
import com.dreamer.education.bean.ro.CourseResponse;
import com.dreamer.education.dao.TCourseFavoriteDao;
import com.dreamer.education.utils.Page;

/**
 * 课程收藏业务访问接口
 * @since 2013-11-21 下午3:54:29
 * @author broken_xie
 */
@Service
public class TCourseFavoriteService {
    
    /** 课程收藏数据访问接口 */
    @Autowired
    private TCourseFavoriteDao courseFavoriteDao;
    
    /**
     * 收藏课程
     * @param ucourseid 课程id
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public Map<String, Object> collect(String ucourseid, SessionContainer sessionContainer) {
        Map<String, Object> map = new HashMap<String, Object>();
        TCourseFavorite courseFavorite = courseFavoriteDao.findByUcourseidAndUuserid(ucourseid, sessionContainer.getUser().getUuid());
        if (null != courseFavorite) {
            map.put("result", "failure");
            map.put("error", "该课程已经您的课程收藏中，无法继续收藏");
            return map;
        } else {
            TCourseFavorite favorite = new TCourseFavorite();
            favorite.setDcreate(new Date());
            favorite.setDupdate(favorite.getDcreate());
            favorite.setUcourseid(ucourseid);
            favorite.setUuid(getUUID());
            favorite.setUuserid(sessionContainer.getUser().getUuid());
            courseFavoriteDao.save(favorite);
            map.put("result", "success");
            return map;
        }
    }
    
    /**
     * 分页查询课程收藏集合
     * @param currentPage 当前页码
     * @param sessionContainer 会话容器
     * @return
     * @author broken_xie
     */
    public Page<CourseResponse> findPageByQuery(int currentPage, SessionContainer sessionContainer) {
        Page<CourseResponse> page = new Page<CourseResponse>(currentPage);
        return courseFavoriteDao.findPageByQuery(page, sessionContainer);
    }
}
