package com.sap.cx.productviews.model.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductCassandraRepository extends CassandraRepository<Product, UUID> {

    @Query("update productviews.product SET views = views + 1 WHERE code = ?0")
    void updateProduct(String code);


    @Query("select * from productviews.product WHERE code = ?0")
    Product findByCode(String code);


}
