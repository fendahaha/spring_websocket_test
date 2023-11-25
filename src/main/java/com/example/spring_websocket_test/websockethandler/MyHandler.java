package com.example.spring_websocket_test.websockethandler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished(session_id " + session.getId() + ")");
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        TextMessage response = new TextMessage(message.getPayload());
        session.sendMessage(response);
//        System.out.println("message:" + message.getPayload());
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("afterConnectionClosed");
    }

}
