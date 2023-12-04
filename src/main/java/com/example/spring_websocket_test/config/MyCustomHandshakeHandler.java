package com.example.spring_websocket_test.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.net.URI;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyCustomHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
        System.out.println("determineUser");
        // 实现您的用户身份认证逻辑
        // 返回一个实现了 Principal 接口的对象
        URI uri = request.getURI();
        String query = uri.getQuery();
        String[] split = query.split("&");
        HashMap<String, String> hashMap = new HashMap<>();
        Arrays.stream(split).forEach((k) -> {
            String[] split1 = k.split("=");
            hashMap.put(split1[0], split1[1]);
        });
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return hashMap.get("username");
            }
        };
        return principal;
    }
}
