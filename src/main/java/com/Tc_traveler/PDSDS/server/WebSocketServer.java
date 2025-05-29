package com.Tc_traveler.PDSDS.server;


import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ServerEndpoint("/api/websocket/{user_id}")
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private Integer user_id;

    @OnOpen
    public void onOpen(Session session, @PathParam("user_id")Integer user_id){
        this.user_id = user_id;
    }

    @OnClose
    public void onClose(){

    }

    @OnMessage
    public void onMessage(String message,Session session){
        try {
            session.getBasicRemote().sendText("消息收到");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
