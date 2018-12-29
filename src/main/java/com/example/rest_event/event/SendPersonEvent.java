package com.example.rest_event.event;

import com.example.rest_event.model.Person;
import org.springframework.context.ApplicationEvent;

public class SendPersonEvent extends ApplicationEvent {
    private Person person;

    public SendPersonEvent(Person person) {
        super(person);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
