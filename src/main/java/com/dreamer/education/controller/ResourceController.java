package com.dreamer.education.controller;

import static com.dreamer.education.utils.StringUtils.getUUID;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dreamer.education.bean.po.TResource;
import com.dreamer.education.bean.qo.ResourceQuery;
import com.dreamer.education.service.TResourceService;
import com.google.gson.Gson;

/**
 * 资源控制器
 * @since 2013-11-14 下午4:34:49
 * @author broken_xie
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
    
    /** 资源业务访问接口 */
    @Autowired
    private TResourceService resourceService;
    
    /**
     * 资源上传
     * @return
     * @author broken_xie
     * @throws IOException
     */
    @RequestMapping("/add")
    public String add(TResource resource, MultipartHttpServletRequest request) throws IOException {
        MultipartFile multipartFile = request.getFile("videoImg");
        String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
        String filename = getUUID() + String.valueOf(System.currentTimeMillis());
        File dir = new File(realPath + File.separator + "file/videoImg/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir + File.separator + filename + ".png");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.flush();
        fos.close();
        resource.setCpictureurl("/file/videoImg/" + filename + ".png");
        resourceService.add(resource, getSessionContainer());
        return SUCCESS;
    }
    
    /**
     * 校验资源
     * @param cname 资源名称
     * @return
     * @author broken_xie
     */
    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String cname) {
        Object[][] result = new Object[1][3];
        result[0][0] = "cname";
        boolean isCnameExist = resourceService.isCnameExist(cname);
        result[0][1] = !isCnameExist;
        if (isCnameExist) {
            result[0][2] = "* 资源名称已存在，请重新填写！";
        }
        return new Gson().toJson(result);
    }
    
    /**
     * 获取资源列表
     * @param query 资源查询对象
     * @param currentPage 当前页码
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/list")
    public String list(ResourceQuery query, @RequestParam(defaultValue = "1") int currentPage, Model model) {
        model.addAttribute("page", resourceService.findPageByQuery(query, currentPage));
        return "main/resource/list";
    }
    
    /**
     * 查看
     * @param uuid 资源uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(String uuid, Model model) {
        model.addAttribute("resource", resourceService.findForView(uuid));
        return mainPage();
    }
    
    /**
     * 设置免费
     * @param uuid 资源uuid
     * @param free 免费状态【0：非免费；1：免费】
     * @return
     * @author broken_xie
     */
    @RequestMapping("/free")
    @ResponseBody
    public Map<String, String> free(String uuid, String free) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            resourceService.free(uuid, free, getSessionContainer());
            map.put("result", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }
        return map;
    }
}
