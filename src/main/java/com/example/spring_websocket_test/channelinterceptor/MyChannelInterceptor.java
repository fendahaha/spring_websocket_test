package com.example.spring_websocket_test.channelinterceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.security.Principal;

public class MyChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        SimpMessageHeaderAccessor headerAccessor = MessageHeaderAccessor.getAccessor(message, SimpMessageHeaderAccessor.class);

        if (headerAccessor != null && SimpMessageType.CONNECT.equals(headerAccessor.getMessageType())) {
            // 设置用户信息
            headerAccessor.setUser(new Principal() {
                @Override
                public String getName() {
                    return "fffkk";
                }
            });
        }

        if (headerAccessor != null && SimpMessageType.SUBSCRIBE.equals(headerAccessor.getMessageType())) {
            Principal user = headerAccessor.getUser();
            System.out.println(user.getName());
        }

        if (headerAccessor != null && SimpMessageType.MESSAGE.equals(headerAccessor.getMessageType())) {

        }

        return message;
    }
}
