package com.example.rest_event.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SendPersonListener implements ApplicationListener<SendPersonEvent> {
    @Override
    public void onApplicationEvent(SendPersonEvent sendPersonEvent) {
        showOnConsolePerson(sendPersonEvent);
    }

    void showOnConsolePerson(SendPersonEvent sendPersonEvent) {
        System.out.println("first listener");
        System.out.println(sendPersonEvent.getPerson().toString());
    }

    @PostConstruct
    public void preConstruct() {
        System.out.println("Post Construct");
    }
}