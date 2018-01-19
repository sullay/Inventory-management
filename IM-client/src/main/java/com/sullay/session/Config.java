package com.sullay.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class Config {
 
        @Bean
        public JedisConnectionFactory connectionFactory() {
                return new JedisConnectionFactory();
        }
}