package com.xuan.erp.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


import java.time.Duration;

/**
 * Jedis配置
 */

//@Configuration
@EnableCaching
public class JedisConfig extends CachingConfigurerSupport{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private int database;
    
    @Value("${spring.redis.timeout}")
    private int timeout;

    /*
     * SpirngBoot2.x
     */
    @Value("${redis.jedis.pool.maxIdle}")
    private int maxIdle;

    @Value("${redis.jedis.pool.maxTotal}")
    private int maxTotal;

    /*
     * JedisPool实例
     */
    @Bean
    public JedisPool redisPoolFactory() {        
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(), host, port, timeout, password);
        logger.info("JedisPool注入成功!");
        return jedisPool;
    }

    /*
     * JedisPool配置
     */
    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();    	    	
    	//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
    	jedisPoolConfig.setBlockWhenExhausted(true);
    	//设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
    	jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
    	//是否启用pool的jmx管理功能, 默认true
    	jedisPoolConfig.setJmxEnabled(true);
    	//MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
    	jedisPoolConfig.setJmxNamePrefix("pool");
    	//是否启用后进先出, 默认true
    	jedisPoolConfig.setLifo(true);
    	//最大空闲连接数, 默认8个
    	jedisPoolConfig.setMaxIdle(maxIdle);
    	//最大连接数, 默认8个
    	jedisPoolConfig.setMaxTotal(maxTotal);
    	//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
    	jedisPoolConfig.setMaxWaitMillis(-1);
    	//逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
    	jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);
    	//最小空闲连接数, 默认0
    	jedisPoolConfig.setMinIdle(0);
    	//每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
    	jedisPoolConfig.setNumTestsPerEvictionRun(3);
    	//对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)   
    	jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);
    	//在获取连接的时候检查有效性, 默认false
    	jedisPoolConfig.setTestOnBorrow(false);
    	//在空闲时检查有效性, 默认false
    	jedisPoolConfig.setTestWhileIdle(false);
    	//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
    	jedisPoolConfig.setTimeBetweenEvictionRunsMillis(-1);    	
        return jedisPoolConfig;
    }

    /*
     * JedisClient配置
     */
    @Bean
    public JedisClientConfiguration getJedisClientConfiguration() {
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder = (
                JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        GenericObjectPoolConfig GenericObjectPoolConfig = new GenericObjectPoolConfig();
        GenericObjectPoolConfig.setMaxIdle(1000);
        GenericObjectPoolConfig.setMaxTotal(100);
        GenericObjectPoolConfig.setMinIdle(100);
        return JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).build();
    }

    /*
     * Jedis连接工厂配置
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
    	// Jedis标准端配置
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        // Jedis客户端配置
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
        //jedisClientConfiguration.readTimeout(Duration.ofMillis(timeout));// 读取超时
        //jedisClientConfiguration.usePooling(); // 使用连接池
        //jedisClientConfiguration.useSsl(); // 使用SSL
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        logger.info("JedisConnectionFactory注入");
        return factory;
    }   

    /*
     * Redis缓存管理器配置
     */
    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {        
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        //对key指定缓存时间,设置默认超过期时间是30秒
        redisCacheConfiguration.entryTtl(Duration.ofSeconds(30));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(jedisConnectionFactory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        logger.info("cacheManager注入");
        return redisCacheManager;
    }

    /*
     * Redis缓存模板器配置
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate() {        
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        logger.info("redisTemplatet注入");
        return redisTemplate;
    }


}
