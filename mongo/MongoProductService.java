package com.sap.cx.productviews.productviews.services;

import com.sap.cx.productviews.productviews.model.mongo.Product;
import com.sap.cx.productviews.productviews.model.mongo.ProductMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class MongoProductService {

    private static final Logger LOG = LoggerFactory.getLogger(MongoProductService.class);

    private ProductMongoRepository productMongoRepository;

    public MongoProductService(ProductMongoRepository productMongoRepository) {
        this.productMongoRepository = productMongoRepository;
    }

    public void productHit(String code) {
        Instant startRead = Instant.now();
        Product product = productMongoRepository.findByCode(code);
        Instant finishRead = Instant.now();
        LOG.info("Read time:" + Duration.between(startRead, finishRead).toMillis());

        if (product == null) {
            product = new Product(code, 1);
        } else {
            product.setHits(product.getHits() + 1);
        }

        Instant start = Instant.now();
        productMongoRepository.save(product);
        Instant finish = Instant.now();

        LOG.info("Write time:" + Duration.between(start, finish).toMillis());
    }
}
