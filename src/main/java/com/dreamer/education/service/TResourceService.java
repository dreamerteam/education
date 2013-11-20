package com.dreamer.education.service;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TResource;
import com.dreamer.education.bean.qo.ResourceQuery;
import com.dreamer.education.bean.ro.ResourceResponse;
import com.dreamer.education.dao.TResourceDao;
import com.dreamer.education.utils.Page;

/**
 * 资源业务访问接口
 * @since 2013-11-14 下午4:36:16
 * @author broken_xie
 */
@Service
public class TResourceService {
    
    /** 资源数据访问接口 */
    @Autowired
    private TResourceDao resourceDao;
    
    /**
     * 资源名称是否已经存在【true：存在；false：不存在】
     * @param cname资源名称
     * @return
     * @author broken_xie
     */
    public boolean isCnameExist(String cname) {
        return 0 == resourceDao.findByCname(cname).size() ? false : true;
    }
    
    /**
     * 新增资源
     * @param resource 资源信息
     * @param sessionContainer 会话容器
     * @author broken_xie
     */
    public void add(TResource resource, SessionContainer sessionContainer) {
        resource.setCtype("video");
        resource.setDcreate(new Date());
        resource.setDupdate(resource.getDcreate());
        resource.setUuid(getUUID());
        resource.setUuserid(sessionContainer.getUser().getUuid());
        resource.setCfree("0");
        resourceDao.save(resource);
    }
    
    /**
     * 分页查询资源集合
     * @param query 资源查询对象
     * @param currentPage 当前页码
     * @return
     * @author broken_xie
     */
    public Page<ResourceResponse> findPageByQuery(ResourceQuery query, int currentPage) {
        Page<ResourceResponse> page = new Page<ResourceResponse>(currentPage);
        return resourceDao.findPageByQuery(query, page);
    }
    
    /**
     * 根据资源uuid查找资源【编辑、查看】
     * @param uuid 资源uuid
     * @return
     * @author broken_xie
     */
    public TResource findForView(String uuid) {
        return resourceDao.findByUuid(uuid);
    }
    
    /**
     * 查找免费资源
     * @return
     * @author broken_xie
     */
    public List<TResource> findForFree() {
        return resourceDao.findForFree();
    }
    
    /**
     * 设置免费状态
     * @param uuid 主键id
     * @param free 免费状态
     * @param sessionContainer 会话容器
     * @author broken_xie
     */
    public void free(String uuid, String free, SessionContainer sessionContainer) {
        TResource resource = resourceDao.findByUuid(uuid);
        resource.setCfree(free);
        resource.setDupdate(new Date());
        resource.setUuserid(sessionContainer.getUser().getUuid());
        resourceDao.update(resource);
    }
}
