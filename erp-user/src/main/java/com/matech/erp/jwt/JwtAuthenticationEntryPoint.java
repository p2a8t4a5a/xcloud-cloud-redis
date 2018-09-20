package com.matech.erp.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * 默认情况下登陆失败自定义跳转页面
 * 判断是否ajax请求，是ajax请求则返回json，否则跳转失败页面
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) 
    		throws IOException, ServletException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        response.sendError(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase());
        
//        if(isAjaxRequest(request)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
//        }else{
//            response.sendRedirect("/login");
//        }        
    }
    
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
    
}