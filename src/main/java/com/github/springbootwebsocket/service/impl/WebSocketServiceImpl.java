package com.github.springbootwebsocket.service.impl;

import com.github.springbootwebsocket.pojo.WebSocketDO;
import com.github.springbootwebsocket.service.WebSocketService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

/**
 * Created in 09:31 2019-04-01
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class WebSocketServiceImpl implements WebSocketService {

    /**
     * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
     */
    @Resource
    private Map<String, Session> onlineSessions;

    /**
     * 公共方法：发送信息给所有人
     */
    @Override
    @SneakyThrows(IOException.class)
    public void sendMessageToAll(WebSocketDO webSocketDO) {
        for (Map.Entry<String, Session> entry : onlineSessions.entrySet()) {
            String k = entry.getKey();
            Session v = entry.getValue();
            v.getBasicRemote().sendText(webSocketDO.getMsg().toString());
        }
    }

}
