package com.github.springbootwebsocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created in 18:35-2019-03-29
 * Project name spring-boot-websocket
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Getter
@Setter
@ToString
@AllArgsConstructor
public class SocketMessageDO {

    public String message;

    public String date;


}
