package tech.razymov.omega.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tech.razymov.omega.entity.Product;

@Component
class KafkaListenersExample {
    @KafkaListener(topics = "demo_topic", groupId = "myGroup")
    void listener(Product data) {
        System.out.println(data);
    }

}