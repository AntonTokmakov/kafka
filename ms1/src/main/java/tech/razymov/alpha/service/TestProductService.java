package tech.razymov.alpha.service;

import tech.razymov.alpha.entity.ProductTest;

public interface TestProductService {

    void sendMessages(ProductTest testOptions, String topicName);

}
