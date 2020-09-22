package com.sap.cx.productviews.productviews.model.mongo;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String id;
    private String code;

    private Long hits;

    public Product(String code, long hits) {
        this.code = code;
        this.hits = hits;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("Product[id=%s, code='%s', hits='%s']", id,
                code, hits);
    }
}

