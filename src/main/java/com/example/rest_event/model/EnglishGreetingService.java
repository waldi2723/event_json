package com.example.rest_event.model;

import org.springframework.context.annotation.Primary;

@Primary
public class EnglishGreetingService implements GreetingService {
    @Override
    public void greeting() {
        System.out.println(this.getClass().getName());
    }
}
