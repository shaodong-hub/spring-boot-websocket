package com.github.springbootwebsocket.controller;

import com.github.springbootwebsocket.pojo.WebSocketDO;
import com.github.springbootwebsocket.service.impl.WebSocketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

/**
 * Created in 09:22 2019-04-01
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
@ServerEndpoint("/chat")
public class WebSocketServer {

    /**
     * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
     */
    @Autowired
    private Map<String, Session> onlineSessions;

    @Autowired
    private WebSocketServiceImpl socketService;

    /**
     * 当客户端打开连接：1.添加会话对象 2.更新在线人数
     */
    @OnOpen
    public void onOpen(Session session) {
        onlineSessions.put(session.getId(), session);
        socketService.sendMessageToAll(new WebSocketDO<>("OnOpen"));
    }

    @OnMessage
    public void onMessage(String message) {
        log.info(message);
    }

    /**
     * 当关闭连接：1.移除会话对象 2.更新在线人数
     */
    @OnClose
    public void onClose(Session session) {
        onlineSessions.remove(session.getId());
        socketService.sendMessageToAll(new WebSocketDO<>(""));
    }

    /**
     * 当通信发生异常：打印错误日志
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }


}
