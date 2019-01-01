package com.example.rest_event.configuration;

import com.example.rest_event.event.AddToDatabaseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AsynchronousSpringEventsConfig {
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource =
                new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("nokia27");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }


    @Bean("dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {


       /*   Created from:

       <!--Initialization for TransactionManager -->
   <bean id ="transactionManager"
    class ="org.springframework.jdbc.datasource.DataSourceTransactionManager">
      <property name ="dataSource"ref ="dataSource"/>
   </bean> */

        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(driverManagerDataSource()); //using method from this conifguration file
        return dataSourceTransactionManager;
    }

    @Bean
    @Autowired
    public AddToDatabaseListener addToDatabaseListener(JdbcTemplate jdbcTemplate) {
        return new AddToDatabaseListener(dataSourceTransactionManager(), jdbcTemplate);
    }
}