package com.github.springbootwebsocket.service;

import com.github.springbootwebsocket.pojo.WebSocketDO;

/**
 * Created in 10:12 2019-04-01
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


public interface WebSocketService {

    void sendMessageToAll(WebSocketDO webSocketDO);

}
