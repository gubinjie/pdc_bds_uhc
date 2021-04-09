package com.paat.pds_bds_uhc_backend.api.security.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author binjie.gu
 * @version 1.0.0
 * @createTime 2021年04月07日
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(session.getAttribute("USER_NAME"));
        System.out.println("----拦截到了");
        return true;
    }
}
