package com.matech.erp.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class AppInitializer extends AbstractHttpSessionApplicationInitializer { 

	public AppInitializer() {
		super(AppConfig.class); 
	}
}

