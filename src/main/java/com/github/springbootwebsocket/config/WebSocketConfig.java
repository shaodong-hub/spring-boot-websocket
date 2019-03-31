package com.github.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/**
 * \@EnableWebSocketMessageBroker注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息，
 * 这时候控制器（controller）开始支持@MessageMapping,就像是使用@requestMapping一样。
 * <p>
 * <p>
 * Created in 18:28-2019-03-29
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 这句表示在topic和user这两个域上可以向客户端发消息
        registry.enableSimpleBroker("/topic", "/user");
        // 这句表示客户端向服务端发送时的主题上面需要加"/app"作为前缀；
        registry.setApplicationDestinationPrefixes("/app");
        // 这句表示给指定用户发送（一对一）的主题前缀是“/user/”;
        registry.setUserDestinationPrefix("/user/");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
        // setAllowedOrigins 添加允许跨域访问
        registry.addEndpoint("/hello").setAllowedOrigins("*");
//        registry.addEndpoint("/my-websocket").setAllowedOrigins("*").withSockJS();
    }


}
