package com.matech.erp.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * MyBatis扫描接口，使用的tk.mybatis.spring.mapper.MapperScannerConfigurer，如果你不使用通用Mapper
 */
//@Configuration
//注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
//@AutoConfigureAfter(MyBatisConfig.class)

public class MyBatisMapperScannerConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        
        //Mapper接口目录，具体的mapper
        mapperScannerConfigurer.setBasePackage("com.matech.erp.mapper");
        
        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.matech.erp.mybatis.BaseMapper");
        properties.setProperty("notEmpty", "false"); //insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
