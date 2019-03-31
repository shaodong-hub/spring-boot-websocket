package com.github.springbootwebsocket.controller;

import com.github.springbootwebsocket.pojo.SocketMessageDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;

/**
 * Created in 18:37-2019-03-29
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class SocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public SocketMessageDO sendTo(SocketMessageDO message) {
        log.info("Received hello: {}", message.toString());
        return message;
    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public SocketMessageDO sendToUser(SocketMessageDO message) {
        log.info("Received hello: {}", message.toString());
        return message;
    }


}
