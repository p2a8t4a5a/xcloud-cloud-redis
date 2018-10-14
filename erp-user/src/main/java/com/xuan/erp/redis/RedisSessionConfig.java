package com.xuan.erp.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Redis Session配置
 */

@Configuration
@EnableRedisHttpSession //开启Spring session支持
public class RedisSessionConfig {


}

