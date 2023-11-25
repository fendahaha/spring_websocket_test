package com.example.spring_websocket_test.websockethandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MyHandshakeInterceptor implements HandshakeInterceptor {
    public MyHandshakeInterceptor() {
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        System.out.println("beforeHandshake");
        HttpHeaders headers = request.getHeaders();
//        BiConsumer<? super String, ? super List<String>> biConsumer = (key, value) -> {
//            System.out.println(key + ":" + value);
//        };
//        headers.forEach(biConsumer);
        System.out.println(request.getURI());
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//        System.out.println("afterHandshake");
    }
}
