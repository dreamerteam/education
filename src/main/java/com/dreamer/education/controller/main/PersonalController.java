package com.dreamer.education.controller.main;

import static com.dreamer.education.utils.Encryption.MD5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.bean.po.TManager;
import com.dreamer.education.bean.po.TTeacher;
import com.dreamer.education.bean.po.TUser;
import com.dreamer.education.bean.ro.PersonalRequest;
import com.dreamer.education.controller.BaseController;
import com.dreamer.education.service.PersonalService;

/**
 * 个人中心控制器
 * @since 2013-11-13 下午3:13:16
 * @author broken_xie
 */
@Controller
@RequestMapping("/manage/personal")
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
        return "/main/personal/view";
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
        return redirect("/manage/personal/view");
    }
    
    /**
     * 校验原密码
     * @param psw 原密码
     * @return
     * @author broken_xie
     */
    @RequestMapping("/validatePsw")
    @ResponseBody
    public Map<String, String> validatePsw(String psw) {
        Map<String, String> map = new HashMap<String, String>();
        boolean isEqual = MD5(psw).equals(getSessionContainer().getUser().getCpassword());
        if (isEqual) {
            map.put("result", "success");
            return map;
        } else {
            map.put("result", "failure");
            return map;
        }
    }
    
    /**
     * 更新密码
     * @param psw 密码
     * @return
     * @author broken_xie
     */
    @RequestMapping("/updatePsw")
    @ResponseBody
    public Map<String, String> updatePsw(String psw) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            TUser user = personalService.updatePsw(psw, getSessionContainer());
            getSessionContainer().setUser(user);
            map.put("result", "success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "failure");
            map.put("error", "操作失败，请稍后再试");
            return map;
        }
    }
    
}
