package com.github.springbootwebsocket.schedule;

import com.github.springbootwebsocket.pojo.WebSocketDO;
import com.github.springbootwebsocket.service.WebSocketService;
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
public class WebSocketTask {

    @Resource
    private WebSocketService socketService;

    /**
     * task
     */
    @Scheduled(fixedRate = 1000)
    public void task() {
        socketService.sendMessageToAll(new WebSocketDO<>("message:" + new Date().toString()));
    }

}
