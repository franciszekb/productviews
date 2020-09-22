package com.sap.cx.productviews.productviews.model.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface ProductMongoRepository extends MongoRepository<Product, String> {
    Product findByCode(@Param("code") String code);
}
