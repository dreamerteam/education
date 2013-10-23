package com.dreamer.education.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

/**
 * 验证码控制器
 * @since 2013-10-5 下午10:23:54
 * @author broken_xie
 */
@Controller
public class CaptchaController extends BaseController {
    
    /** 验证码生成器 */
    @Autowired
    private DefaultKaptcha captchaProducer;
    
    /**
     * 生成验证码
     * @param time 操作时间
     * @param response
     * @param session
     * @return
     * @throws IOException
     * @author broken_xie
     */
    @RequestMapping("/captcha/{time}")
    @ResponseBody
    public String captcha(@PathVariable(value = "time") String time, HttpServletResponse response, HttpSession session) throws IOException {
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        properties.setProperty(Constants.KAPTCHA_BORDER, "no");
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "red");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "27");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        String captcha = captchaProducer.createText();
        BufferedImage bi = captchaProducer.createImage(captcha);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(bi, "jpg", os);
        session.setAttribute(time, captcha);
        os.flush();
        os.close();
        response.flushBuffer();
        return null;
    }
}
