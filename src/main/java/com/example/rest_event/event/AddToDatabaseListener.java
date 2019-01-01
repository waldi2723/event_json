package com.example.rest_event.event;

import com.example.rest_event.model.Student;
import com.example.rest_event.model.StudentRowMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;
import java.util.List;

public class AddToDatabaseListener implements ApplicationListener<AddToDatabaseEvent> {
    private DataSourceTransactionManager dataSourceTransactionManager;
    private JdbcTemplate jdbcTemplate;

    public AddToDatabaseListener(DataSourceTransactionManager dataSourceTransactionManager, JdbcTemplate jdbcTemplate) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void onApplicationEvent(AddToDatabaseEvent addToDatabaseEvent) {
        performDbAction(addToDatabaseEvent);
    }

    public void performDbAction(AddToDatabaseEvent addToDatabaseEvent) {

        //  TransactionStatus status = getTransactionStatus(); -- comment due to using AOP


        try {
            Student student = (Student) addToDatabaseEvent.getSource();
            String SQL1 = "insert into student (name, surname) values (?, ?)";

            jdbcTemplate.update(SQL1, student.getName(), student.getSurname());

            String SQL2 = "select * from student";

            if (true) {
                throw new BadSqlGrammarException("asdf", SQL2, new SQLException());
            }
            List<Student> studentList = jdbcTemplate.query(SQL2, new StudentRowMapper());
            studentList.stream().forEach(x -> System.out.println(x.toString()));
            //   dataSourceTransactionManager.commit(status); -- comment due to using AOP

        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            // dataSourceTransactionManager.rollback(status); -- comment due to using AOP
            throw e;
        }
    }

    public TransactionStatus getTransactionStatus() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
        return status;
    }


}
