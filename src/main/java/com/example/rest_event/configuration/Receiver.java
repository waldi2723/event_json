package com.example.rest_event.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger logger = LogManager.getLogger(Receiver.class);

    private CountDownLatch latch;

    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
    }
}

