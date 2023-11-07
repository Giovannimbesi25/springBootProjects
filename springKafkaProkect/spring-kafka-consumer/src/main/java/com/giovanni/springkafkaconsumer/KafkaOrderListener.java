package com.giovanni.springkafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import org.giovanni.springkafkacommons.NewOrder;

@Component
public class KafkaOrderListener {

    @KafkaListener(topics = "new-orders", groupId = "lesson_group")
    public void listen(NewOrder order) {

        System.out.println("Received order : " + order);
    }
}