package com.example.rest_event.controller;

import com.example.rest_event.configuration.AsynchronousSpringEventsConfig;
import com.example.rest_event.event.AddToDatabaseEvent;
import com.example.rest_event.event.SendPersonEvent;
import com.example.rest_event.model.GreetingService;
import com.example.rest_event.model.Person;
import com.example.rest_event.model.Student;
import com.example.rest_event.service.SendPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MySimpleRestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private SendPersonService sendPersonService;

    @Autowired
    private AsynchronousSpringEventsConfig asynchronousSpringEventsConfig;


    @PostMapping
    public Object getRequest(@RequestBody Person[] person) {
        eventPublisher.publishEvent(new SendPersonEvent(person[0]));
        Person student = new Person(person[0].getName(), person[0].getSurname(), person[0].getAge());
        return "okej";
    }

    @PostMapping
    @RequestMapping("/student")
    @Autowired(required = false)
    public String postStudent(@RequestBody Student student ) {
        greetingService.greeting();

        eventPublisher.publishEvent(new AddToDatabaseEvent(student));
        asynchronousSpringEventsConfig.jdbcTemplate();
        return "ok";
    }
}
