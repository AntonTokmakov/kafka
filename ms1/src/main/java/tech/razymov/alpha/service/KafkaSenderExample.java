package tech.razymov.alpha.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tech.razymov.alpha.entity.Product;

@Component
@RequiredArgsConstructor
public class KafkaSenderExample {

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public void sendMessage(Product product, String topicName) {
        kafkaTemplate.send(topicName, product);
    }

}