package com.example.rest_event.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SxecondPersonApplicationEventListener implements ApplicationListener<SendPersonEvent> {
    @Override
    public void onApplicationEvent(SendPersonEvent sendPersonEvent) {
        System.out.println("drugi listener");
    }
}
