package com.myl.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginIn
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/17  20:09
 * 权限拦截
 */
public class QuanXianIn implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if (session.getAttribute("student") != null) {
//            if(!request.getRequestURI().contains("student")){
//                response.sendRedirect("/quanxian.jsp");
//
//                return  false;
//            }
//            return true;
//        }
//        if (session.getAttribute("teacher") != null) {
//            if(!request.getRequestURI().contains("teacher")){
//                response.sendRedirect("/quanxian.jsp");
//
//
//                return  false;
//            }
//            return true;
//        }
//
//        if (session.getAttribute("admin") != null) {
//            if(!request.getRequestURI().contains("admin")){
//                response.sendRedirect("/quanxian.jsp");
//
//                return  false;
//            }
//            return true;
//        }
//
//

        return true;

    }
}
