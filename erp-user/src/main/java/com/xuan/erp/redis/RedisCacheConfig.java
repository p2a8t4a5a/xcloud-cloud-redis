package com.xuan.erp.redis;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;


/**
 * Redis缓存配置
 * org.springframework.boot.autoconfigure.data.redis.RedisProperties
 *
 * @author linweixuan@gmail.com
 * @date 2018年
 */

@Configuration
@EnableCaching //开启缓存注解支持
public class RedisCacheConfig extends CachingConfigurerSupport {

    //@Value("${spring.redis.sentinel.master}")
    private String master;
	
    //@Value("${spring.redis.sentinel.nodes}")
    private String nodes;

    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;
    
    /**
     * 自定义生成Redis主键
     */
    @Bean
    public KeyGenerator KeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    /**
     * Redis哨兵配置
     */
    //@Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        String[] host = nodes.split(",");
        for(String redisHost : host){
            String[] item = redisHost.split(":");
            String ip = item[0];
            String port = item[1];
            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
        }
        configuration.setMaster(master);
        return configuration;
    }
    
    /**
     * Redis缓存管理器配置
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();

        //对key指定缓存时间,设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
        return cacheManager;
    }
    
	// 缓存管理器
	//@Bean
	public CacheManager cacheManager2() {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
				.fromConnectionFactory(lettuceConnectionFactory);
		@SuppressWarnings("serial")
		Set<String> cacheNames = new HashSet<String>() {
			{
				add("myCache");
			}
		};
		builder.initialCacheNames(cacheNames);
		return builder.build();
	}
    
  
    /**
     *  各种RedisTemplate配置
     *
     * 	设置添加序列化器
     * 	key: 使用string序列化器
     * 	value: 使用Json序列化器
     */    
	@Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);

        //设置开启事务
        //template.setEnableTransactionSupport(true);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
	
    //@Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate2(LettuceConnectionFactory factory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();

        //设置值键系列化
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(factory);
        return template;
    }
    
    //@Bean
    public RedisTemplate<Object, Object> redisTemplate3(RedisConnectionFactory factory) {
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<Object, Object> template = new RedisTemplate<>();

        //设置开启事务
        template.setEnableTransactionSupport(true);

        //设置主键系列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();
        return template;
    }
    
    //@Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory factory) {
     // 设置序列化
     Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
     ObjectMapper om = new ObjectMapper();
     om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
     om.enableDefaultTyping(DefaultTyping.NON_FINAL);
     jackson2JsonRedisSerializer.setObjectMapper(om);

     // 配置redisTemplate
     RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
     redisTemplate.setConnectionFactory(factory);
     RedisSerializer<?> stringSerializer = new StringRedisSerializer();
     redisTemplate.setKeySerializer(stringSerializer);// key序列化
     redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);// value序列化
     redisTemplate.setHashKeySerializer(stringSerializer);// Hash key序列化
     redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);// Hash value序列化
     redisTemplate.afterPropertiesSet();
     return redisTemplate;
    }    
}