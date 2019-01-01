package com.example.rest_event.event;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.SimpleTransactionStatus;

import javax.sql.DataSource;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AddToDatabaseListenerTest {

    @InjectMocks
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private Log logger;

    @Mock
    private TransactionDefinition transactionDefinition;

    @Mock
    private DataSource dataSource;

    @InjectMocks
    AddToDatabaseListener addToDatabaseListener;

    @Test
    public void onApplicationEventTest() {
    }


    @Test
    public void testGetTransactionStatus() {

        when(dataSourceTransactionManager.getTransaction(transactionDefinition)).thenReturn(new SimpleTransactionStatus());
        addToDatabaseListener.getTransactionStatus();
    }
}
