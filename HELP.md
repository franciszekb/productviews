# Getting Started
source https://github.com/Azure-Samples/azure-springboot-cosmosdb-cassandra-counter
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-mongodb)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)


1. Docker

    ```shell script
    docker build -t franekbieg/productviews:0.1 .
    docker run -ti --entrypoint /bin/sh franekbieg/productviews:0.1
    ```

1. New product view


    ```shell
    curl -H "Content-Type: application/json" -X POST http://localhost:8080/producthit?code=1234
    curl -s -d '{"name":"Jerry","species":"mouse"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pets
    ```
