package com.xuan.erp.enviroment;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppEnvironmentAware implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
        String projectName = environment.getProperty("project.name");
        System.out.println(projectName);

        //获取到前缀是"spring.datasource." 的属性列表值.
        //RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        //System.out.println("spring.datasource.url="+propertyResolver.getProperty("url"));
    }
}
