package com.dreamer.education.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.ro.PersonalRequest;
import com.dreamer.education.service.PersonalService;

/**
 * 个人中心控制器
 * @since 2013-11-13 下午3:13:16
 * @author broken_xie
 */
@Controller
@RequestMapping("/personal")
public class PersonalController extends BaseController {
    
    /** 个人中心业务访问接口 */
    @Autowired
    private PersonalService personalService;
    
    /**
     * 查看
     * @param uuid 教师uuid
     * @param model
     * @return
     * @author broken_xie
     */
    @RequestMapping("/view")
    public String view(Model model) {
        SessionContainer container = getSessionContainer();
        model.addAttribute("user", container.getUser());
        model.addAttribute("authority", container.getAuthority());
        switch (container.getAuthority()) {
            case "manager":
                model.addAttribute("personal", container.getManager());
                break;
            case "teacher":
                model.addAttribute("personal", container.getTeacher());
                break;
            default:
                break;
        }
        return mainPage();
    }
    
    /**
     * 更新个人信息
     * @param teacher 教师信息
     * @param model
     * @author broken_xie
     */
    @RequestMapping("/update")
    public String update(PersonalRequest personal, Model model) {
        SessionContainer sessionContainer = getSessionContainer();
        Map<String, Object> map = personalService.update(personal, sessionContainer);
        switch ((String) map.get("authority")) {
            case "manager":
                TManager manager = (TManager) map.get("personal");
                sessionContainer.setManager(manager);
                break;
            case "teacher":
                TTeacher teacher = (TTeacher) map.get("personal");
                sessionContainer.setTeacher(teacher);
                break;
            default:
                break;
        }
        return redirect("/personal/view");
    }
}
