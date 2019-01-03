package com.example.rest_event;

import com.example.rest_event.configuration.Receiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class RestEventApplication {

    private static final Logger logger = LogManager.getLogger(RestEventApplication.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(RestEventApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        logger.info("Sending message...");
        template.convertAndSend("chat", "hello");

        latch.await();

        System.exit(0);
    }

}

