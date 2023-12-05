package com.example.spring_websocket_test.websockethandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.net.URI;
import java.security.Principal;
import java.util.Map;

public class MyHandshakeInterceptor2 implements HandshakeInterceptor {
    public MyHandshakeInterceptor2() {
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        System.out.println("beforeHandshake");
//        URI uri = request.getURI();
//        System.out.println(uri);
        attributes.put("my_user_name", "fenda");
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//        System.out.println("afterHandshake");
    }
}
