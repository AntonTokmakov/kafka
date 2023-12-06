package tech.razymov.alpha.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tech.razymov.alpha.entity.Product;
import tech.razymov.alpha.entity.ProductTest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class TestProductServiceImpl implements TestProductService {
    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaTemplate<String, Product> kafkaTemplate;

    @Override
    public void sendMessages(ProductTest testOptions, String topicName) {
        executorService.scheduleAtFixedRate(() -> {
                    Product product = new Product();
                    product.setId((long) getRandomNumber(1, 10));
                    product.setAmount((int) getRandomNumber(10, 1000));
                    product.setName("Product " + getRandomNumber(10, 1000));
                    product.setProductStatus(Product.ProductStatus.INSTOCK);
                    kafkaTemplate.send(topicName, product);
                },
                0,
                testOptions.getDelayInSeconds(),
                TimeUnit.SECONDS
        );
    }

    private double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
