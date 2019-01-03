package com.example.rest_event.service;

import com.example.rest_event.model.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendPersonService {

    @Autowired
    private GreetingService greetingService;


    public void fun(JdbcTemplate jdbcTemplate) {
        int x;
        int i = 3;
        greetingService.greeting();
    }


}
