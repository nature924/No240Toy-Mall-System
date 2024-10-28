package com.wsy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisConfig {

    @Bean
    public Jedis jedis(){
        Jedis jedis = new Jedis("",6379);
//        jedis.auth("root");
        return jedis;
    }
}
