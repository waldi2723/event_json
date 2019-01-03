package com.example.rest_event.controller;

import com.example.rest_event.RestEventApplication;
import com.example.rest_event.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CountDownLatch;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CountDownLatch countDownLatch;


    private static final Logger logger = LogManager.getLogger(RestEventApplication.class);

    @PostMapping(value = "/redis")
    public void getMessageFromRedis(@RequestBody Student student) throws InterruptedException {

        logger.info("Sending message...");
        stringRedisTemplate.convertAndSend("chat", student.toString());

        countDownLatch.await();
    }
}
