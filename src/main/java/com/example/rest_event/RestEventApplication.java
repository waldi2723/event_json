package com.example.rest_event;

import com.example.rest_event.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class RestEventApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(RestEventApplication.class, args);
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);


        jmsTemplate.convertAndSend("mailbox", new Person("Waldemar", "Asdf", 1));
    }
}

