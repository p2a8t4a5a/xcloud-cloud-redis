package com.xuan.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//@Configuration
public class HttpSessionConfig {
	
	/**
	 * bean for http session listener
	 * @return
	 */
    @Bean
    public HttpSessionListener httpSessionListener() {
    	
        return new HttpSessionListener() {
        	// This method will be called when session created
            @Override
            public void sessionCreated(HttpSessionEvent se) {               
                System.out.println("Session Created with session id+" + se.getSession().getId());
            }
            // This method will be automatically called when session destroyed
            @Override
            public void sessionDestroyed(HttpSessionEvent se) {         
                System.out.println("Session Destroyed, Session id:" + se.getSession().getId());
            }
        };
    }
    
    /**
     * bean for http session attribute listener
     * @return
     */
    @Bean                   
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionAttributeListener() {
        	// This method will be automatically called when session attribute added
            @Override
            public void attributeAdded(HttpSessionBindingEvent se) {            
                System.out.println("Attribute Added following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Value:" + se.getName());
            }
            // This method will be automatically called when session attribute removed
            @Override
            public void attributeRemoved(HttpSessionBindingEvent se) {      
                System.out.println("attributeRemoved");
            }
            // This method will be automatically called when session attribute replace
            @Override
            public void attributeReplaced(HttpSessionBindingEvent se) {     
                System.out.println("Attribute Replaced following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Old Value:" + se.getValue());
            }
        };
    }
}