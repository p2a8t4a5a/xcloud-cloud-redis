package com.matech.erp.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;

import com.matech.erp.model.User;


@Configuration
public class ApplicationListenerConfig {

	@Bean
	public ApplicationListener<?> loggingListener() {

		return (ApplicationListener<ApplicationEvent>) event -> {
			if (event instanceof RelationalEvent) {
				System.out.println("Received an event: " + event);
			}
		};
	}

	@Bean
	public ApplicationListener<BeforeSaveEvent> timeStampingSaveTime() {
		return event -> {
			Object entity = event.getEntity();
			if (entity instanceof User) {
				User user = (User) entity;
				//User.timeStamp();
			}
		};
	}	
}
