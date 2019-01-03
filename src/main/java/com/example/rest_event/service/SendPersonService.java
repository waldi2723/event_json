package com.example.rest_event.service;

import com.example.rest_event.model.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendPersonService {

    @Autowired
    private GreetingService greetingService;
    private String x;
    private String y;

    public SendPersonService(@Value("${greetingServiceProperty.x}") String x,
                             @Value("${greetingServiceProperty.y}") String y,
                             @Value("${unknown.param:some default}") String p) {
        this.x = x;
        this.y = y;
    }


    public void fun(JdbcTemplate jdbcTemplate) {
        int x;
        int i = 3;

    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
