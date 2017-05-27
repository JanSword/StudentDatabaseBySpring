package com.biz.std.util;

/**
 * 拦截器
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Intercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getSession().getAttribute("Username").equals("root")&&httpServletRequest.getSession().getAttribute("Password").equals("123456")){
            System.out.println("preHandle");
            return true;
        }

        System.out.println("失败");
        httpServletRequest.getRequestDispatcher("/stddb/login").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
