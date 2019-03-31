package com.github.springbootwebsocket.schedule;

import com.github.springbootwebsocket.pojo.SocketMessageDO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created in 18:15-2019-03-29
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@EnableScheduling
public class ScheduleTask {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    /**
     * \@SendTo("/topic/callback")
     *
     * @return Object
     */
    @Scheduled(fixedRate = 1000)
    public Object callback() {
        SocketMessageDO messageDO = new SocketMessageDO("Message", new Date().toString());
        // 广播 发现消息
        messagingTemplate.convertAndSend("/topic/hello", messageDO.toString());
        // 一对一发送，发送特定的客户端
        messagingTemplate.convertAndSendToUser("", "/message", "");
        return "callback";
    }

}
