package com.mors741.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
public class KafkaSpringBootApplication {

    @Value("${kafka.topic.name}")
    private String topicName;

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringBootApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner runner(KafkaProducer producer, KafkaConsumer consumer) {
        return (args) -> {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                producer.send(topicName, line);
            }
        };
    }
}
