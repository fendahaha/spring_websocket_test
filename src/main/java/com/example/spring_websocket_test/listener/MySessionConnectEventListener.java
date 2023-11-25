package com.example.spring_websocket_test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

//@Component
public class MySessionConnectEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event.getClass() == BrokerAvailabilityEvent.class) {
            System.out.println("BrokerAvailabilityEvent");
        }
        if (event.getClass() == SessionConnectEvent.class) {
            System.out.println("SessionConnectEvent");
//            Message<byte[]> message = ((SessionConnectEvent) event).getMessage();
//            MessageHeaders headers = message.getHeaders();
//            headers.forEach((k, v) -> {
//                System.out.println(k + ":" + v);
//            });
        }
        if (event.getClass() == SessionConnectedEvent.class) {
            System.out.println("SessionConnectedEvent");
        }
        if (event.getClass() == SessionSubscribeEvent.class) {
            System.out.println("SessionSubscribeEvent");
        }
        if (event.getClass() == SessionUnsubscribeEvent.class) {
            System.out.println("SessionUnsubscribeEvent");
        }
        if (event.getClass() == SessionDisconnectEvent.class) {
            System.out.println("SessionDisconnectEvent");
        }
    }
}
