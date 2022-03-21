package com.tik.mysystem.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        LoginRequired loginRequired = method.getMethodAnnotation(LoginRequired.class);
        if (null != loginRequired) {
            //这个是需要拦截的方法
            log.warn("被拦截");
            return loginRequired.loginSuccess();
        } else {
            //这个是不需要拦截的方法
            return true;
        }
    }
}