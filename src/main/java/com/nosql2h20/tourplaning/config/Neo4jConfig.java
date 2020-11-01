package com.nosql2h20.tourplaning.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.nosql2h20.tourplaning.repository")
@EnableTransactionManagement
public class Neo4jConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "com.nosql2h20.tourplaning.model");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://localhost:7687")
                .credentials("neo4j", "pass")
                .autoIndex("none")
                .build();
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}