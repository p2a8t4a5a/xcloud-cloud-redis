package com.matech.erp.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

//@Configuration
public class JedisClusterConfig {

    //@Value("${spring.redis.nodes}")
    private String nodes;

    //@Value("${spring.redis.commandTimeout}")
    private int commandTimeout;

    //@Value("${spring.redis.password}")
    private String password;

    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return JedisCluster
     */
    @Bean
    public JedisCluster getJedisCluster() {
        String[] serverArray = nodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes, commandTimeout, 1000, 1, password, new GenericObjectPoolConfig());
    }

}
