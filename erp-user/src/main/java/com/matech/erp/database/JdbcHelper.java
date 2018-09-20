package com.matech.erp.database;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcHelper {
	
    private static final String driverClass = PropertiesHelper.getValueByKey("jdbc.driverClass");  
    private static final String connectionUrl = PropertiesHelper.getValueByKey("jdbc.url");  
    private static final String username = PropertiesHelper.getValueByKey("jdbc.username");  
    private static final String password = PropertiesHelper.getValueByKey("jdbc.password");
      
    private static JdbcHelper instance = null;
    
    public static JdbcHelper getInstance() {
        if (instance == null) {  
            synchronized (JdbcHelper.class) {
                instance = new JdbcHelper();
            }  
        }  
        return instance;  
    }  
      
    public static Connection getConnection(){  
        try {  
            Class.forName(driverClass);  
            return DriverManager.getConnection(connectionUrl, username, password);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }    
        return null;  
    }

    public static String getDatabaseHost() {
    	String url = connectionUrl.substring(5);
    	URI uri = URI.create(url);
		return uri.getHost();
	}    

    public static int getPort() {
    	String url = connectionUrl.substring(5);
    	URI uri = URI.create(url);
		return uri.getPort();
	}    
    
    public static String getDatabaseName() {
    	String url = connectionUrl.substring(5);
    	URI uri = URI.create(url);
		return uri.getPath().substring(1);
	}    
}  