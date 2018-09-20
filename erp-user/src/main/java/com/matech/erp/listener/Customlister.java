package com.matech.erp.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听servletContext、HttpSession和servletRequest等域对象的创建和销毁事件
 * 启动类中加入@ServletComponentScan
 */
@WebListener
@Slf4j
public class Customlister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("监听器：初始化");
    }

}