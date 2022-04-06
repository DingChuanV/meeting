package com.uin.interceptor;

import com.uin.pojo.Employee;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wanglufei
 * @description: 权限处理
 * @date 2022/4/4/6:43 PM
 */
public class PermissInterceptor implements HandlerInterceptor {
    AntPathMatcher matcher = new AntPathMatcher();

    /**
     * 重写拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @author wanglufei
     * @date 2022/4/4 8:25 PM
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if ("/".equals(url) || "/doLogin".equals(url) || "/register".equals(url) || "/doRegister".equals(url)) {
            return true;
        }

        HttpSession session = request.getSession(true);
        Employee currentUser = (Employee) session.getAttribute("currentUser");
        if (matcher.match("/admin/**", String.valueOf(url))) {
            if (currentUser != null) {
                if (currentUser.getRole() == 2) {
                    return true;
                } else {
                    response.getWriter().write("Forbidden");
                    return false;
                }
            }
        } else {
            if (currentUser != null) {
                return true;
            }
        }
        response.sendRedirect("/");
        return false;
    }
}
