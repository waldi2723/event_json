package com.example.rest_event.event;

import com.example.rest_event.model.Student;
import org.springframework.context.ApplicationEvent;

public class AddToDatabaseEvent extends ApplicationEvent {
    public AddToDatabaseEvent(Student student) {
        super(student);
    }
}
