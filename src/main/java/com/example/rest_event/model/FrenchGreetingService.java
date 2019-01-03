package com.example.rest_event.model;

public class FrenchGreetingService implements GreetingService {
    @Override
    public void greeting(){
        System.out.println(this.getClass().getName());
    }
}
