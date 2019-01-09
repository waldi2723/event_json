package com.example.rest_event.configuration;

import com.example.rest_event.model.Person;
import com.example.rest_event.model.Student;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiverMessage(Student student) {
        System.out.println("Received message: " + student.toString());

    }

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiverMessage(Person person) {
        System.out.println("Received message: " + person.toString());

    }
}