package com.sap.cx.productviews.controllers;

import com.sap.cx.productviews.model.cassandra.Product;
import com.sap.cx.productviews.services.CassandraProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final CassandraProductService cassandraProductService;

    public ProductController(CassandraProductService cassandraProductService) {
        this.cassandraProductService = cassandraProductService;
    }

    @PostMapping(value = "/producthit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> productHit(@RequestParam(value = "code") String code) {
        Product product = cassandraProductService.productHit(code);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/views")
    public ResponseEntity<Product> getProductViews(@RequestParam(value = "code") String code) {
        Product product = cassandraProductService.getProductViews(code);
//        Product product = productRepository.findyById("a");
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    public CassandraProductService getCassandraProductService() {
        return cassandraProductService;
    }
}
