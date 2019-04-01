package com.github.springbootwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 *
 * Created in 18:28-2019-03-29
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Configuration
public class ConfigWebSocket implements WebSocketMessageBrokerConfigurer {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
