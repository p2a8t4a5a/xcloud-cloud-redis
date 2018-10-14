package com.xuan.erp.event;

import org.springframework.context.ApplicationEvent;

/**
 * spring的事件（ApplicationEvent）为bean和bean之间的消息通信提供了支持
 * spring的事件流程如下：
 *
 * 自己的event需要继承 ApplicationEvent，并且写相应的构造函数
 * 定义一个监听器listener，实现ApplicationListener接口，重写onApplicationEvent方法
 * 使用ApplicationContext容器发布事件
 */
public class DemoEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;

    private String message;

    public DemoEvent(Object source,String message){
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}