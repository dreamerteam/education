package com.dreamer.education.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dreamer.education.bean.co.SessionContainer;
import com.dreamer.education.utils.InitParam;

/**
 * 权限拦截器
 * @since 2013-10-5 下午3:36:05
 * @author broken_xie
 */
public class DreamerHandler extends HandlerInterceptorAdapter {
    
    /** url拦截正则表达式 */
    // private static final String URL_PATTERN = "/((?!index)|main/(?!login)).+";
    private static final String URL_PATTERN = "(/manage(?!/login).*)|(/page/manage/.*)";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        requestURI = requestURI.replace(contextPath, "");
        boolean matches = requestURI.matches(URL_PATTERN);
        SessionContainer sessionContainer = (SessionContainer) request.getSession().getAttribute(InitParam.getValue("sessionContainerKey"));
        if (matches && null == sessionContainer) {
            request.getRequestDispatcher("/page/main/login").forward(request, response);
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
