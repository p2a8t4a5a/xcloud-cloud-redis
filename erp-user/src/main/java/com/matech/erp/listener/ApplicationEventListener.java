package com.matech.erp.listener;

import com.matech.erp.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationListener接口，指定监听的事件类型DemoEvent
 */
@Component
public class ApplicationEventListener implements ApplicationListener<DemoEvent> {

    //使用onApplicationEvent接收消息
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMessage();
        System.out.println("接收到的信息："+msg);
    }

}
