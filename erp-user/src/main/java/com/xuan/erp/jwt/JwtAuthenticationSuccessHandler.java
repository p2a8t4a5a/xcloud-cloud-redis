package com.xuan.erp.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JwtTokenUtil jwtUtil;

    public JwtAuthenticationSuccessHandler(JwtTokenUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
    		throws IOException, ServletException {
        if(isAjaxRequest(request)) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json;charset=utf-8");
            User user = (User) authentication.getPrincipal();
            //String accessToken = jwtUtil.generateAccessToken(user);
            //String refreshToken = jwtUtil.generateRefreshToken(user);
            Map<String,Object> mp = new HashMap<String, Object>();
            //mp.put("access_token", accessToken);
            //mp.put("refresh_token", refreshToken);
            //response.getWriter().print(JsonUtil.toJsonSuccess("登录成功",mp));
            response.getWriter().flush();
        }else{
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
}
