package com.github.springbootwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created in 09:29 2019-04-01
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigSessionContainer {

    @Bean
    public Map<String, Session> getSessionContainer(){
        return new ConcurrentHashMap<>(16);
    }


}
