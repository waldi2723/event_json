package com.example.rest_event.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();
        studentBuilder.setName(resultSet.getString("name"));
        studentBuilder.setSurname(resultSet.getString("surname"));
        return studentBuilder.build();
    }
}
