package com.matech.erp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.matech.erp.interceptor.ResourceInterceptor;

@Component
public class WebMvcConfig implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResourceInterceptor resourceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("执行InterceptorRegistry");
        registry.addInterceptor(resourceInterceptor);
    }

}