package com.github.springbootwebsocket.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created in 09:25 2019-04-01
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
@AllArgsConstructor
public class WebSocketDO<T> {


    /**
     * 发送消息
     */
    private T msg;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}