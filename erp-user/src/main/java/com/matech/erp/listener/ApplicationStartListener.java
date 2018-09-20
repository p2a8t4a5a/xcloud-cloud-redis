package com.matech.erp.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 当容器初始化完成之后，需要处理一些操作，如数据的加载、初始化缓存、注册等，
 * 我们就可以通过ApplicationListener来进行操作
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 初始化的容器为root容器
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("父容器：" + event.getApplicationContext().getParent());
        System.out.println("初始化...");

    }
}