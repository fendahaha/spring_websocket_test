package com.example.spring_websocket_test.channelinterceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.support.ChannelInterceptor;

public class MyChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.wrap(message);
        SimpMessageType messageType = accessor.getMessageType();
        if (messageType == SimpMessageType.CONNECT) {
            System.out.println("preSend");
        }
        return message;
    }
}
