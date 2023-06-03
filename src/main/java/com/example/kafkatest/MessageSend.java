package com.example.kafkatest;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@EnableScheduling
public class MessageSend {
    private final String MESSAGE = "message";

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(cron = "0,10,20,30,40,45,50 * * * * ?")
    void sendMessage(){
        kafkaTemplate.send(topic, MESSAGE);
    }
}
