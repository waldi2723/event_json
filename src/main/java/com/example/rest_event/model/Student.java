package com.example.rest_event.model;

public class Student {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static class StudentBuilder {

        private String name;
        private String surname;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setSurname(String surName) {
            this.surname = surName;
            return this;
        }

        public Student build() {
            return new Student(this.name, this.surname);
        }
    }
}
