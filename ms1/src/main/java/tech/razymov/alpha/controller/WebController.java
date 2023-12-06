package tech.razymov.alpha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tech.razymov.alpha.entity.Product;
import tech.razymov.alpha.entity.ProductTest;
import tech.razymov.alpha.service.KafkaSenderExample;
import tech.razymov.alpha.service.TestProductService;
import tech.razymov.alpha.service.TestProductServiceImpl;

@RestController
@RequiredArgsConstructor
public class WebController {

    private final KafkaSenderExample kafkaSenderExample;

    private final TestProductService testProductService;

    @PostMapping("/product")
    private Mono<Product> product(@RequestBody Product product) {
        kafkaSenderExample.sendMessage(product, "demo_topic");
        return Mono.just(product);
    }

    @GetMapping("/productTest")
    private void productTest(@RequestBody ProductTest product) {
        testProductService.sendMessages(product, "demo_topic");
    }

}
