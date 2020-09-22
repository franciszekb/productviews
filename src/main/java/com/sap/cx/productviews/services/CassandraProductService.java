package com.sap.cx.productviews.services;

import com.sap.cx.productviews.model.cassandra.Product;
import com.sap.cx.productviews.model.cassandra.ProductCassandraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class CassandraProductService {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraProductService.class);

    private ProductCassandraRepository productCassandraRepository;

    public CassandraProductService(ProductCassandraRepository productCassandraRepository) {
        this.productCassandraRepository = productCassandraRepository;
    }

    public Product productHit(String code) {
        Instant startRead = Instant.now();
        productCassandraRepository.updateProduct(code);
        Instant finishRead = Instant.now();
        LOG.info("Update time:" + Duration.between(startRead, finishRead).toMillis());

        return getProductViews(code);
    }

    public Product getProductViews(final String code) {
        Instant startRead = Instant.now();
        Product product = productCassandraRepository.findByCode(code);
        Instant finishRead = Instant.now();
        LOG.info("Get time:" + Duration.between(startRead, finishRead).toMillis());
        return product;
    }
}
