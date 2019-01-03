package com.example.rest_event;

import com.example.rest_event.configuration.RabbitMqBeansConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestEventApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RabbitTemplate rabbitTemplate){
        return x -> {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend(RabbitMqBeansConfiguration.topicExchangeName,
                    "foo.bar.xyz", "Hello from rabbitmq");
        };
    }

}

