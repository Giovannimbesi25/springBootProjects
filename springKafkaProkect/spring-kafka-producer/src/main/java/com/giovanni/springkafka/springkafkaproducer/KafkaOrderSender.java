package com.giovanni.springkafka.springkafkaproducer;

import org.giovanni.springkafkacommons.NewOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaOrderSender {

    @Autowired
    private KafkaTemplate<String, NewOrder> kafkaTemplate;

    private String kafkaTopic = "new-orders";

    public void send(NewOrder order) {

        kafkaTemplate.send(kafkaTopic, order);

        System.out.println("Sent : " + order);
    }
}

