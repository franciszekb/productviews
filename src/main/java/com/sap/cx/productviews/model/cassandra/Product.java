package com.sap.cx.productviews.model.cassandra;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;
import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.COUNTER;


@Table
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    @PrimaryKeyColumn(name = "code", type = PARTITIONED)
    private String code;

    @CassandraType(type = COUNTER)
    private Long views;

}
