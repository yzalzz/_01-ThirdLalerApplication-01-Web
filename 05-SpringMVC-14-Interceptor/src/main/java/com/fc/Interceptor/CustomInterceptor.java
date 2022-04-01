package com.fc.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 */
//写拦截器要实现HandlerInterceptor接口
public class CustomInterceptor  implements HandlerInterceptor {
    @Override
    //处理器执行前执行
    //如果返回值是true就放行
    //如果返回至是false就拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器：控制器执行前执行");
        return true;
    }
    //控制器执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器：控制器执行后执行");
    }
//页面渲染完成之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(" 拦截器：页面渲染完成之后执行");
    }
}
