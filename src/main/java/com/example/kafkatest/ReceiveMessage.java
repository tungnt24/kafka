package com.example.kafkatest;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessage {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumer.group-id}")
    void printMessage(String message){
        System.out.println(message + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
