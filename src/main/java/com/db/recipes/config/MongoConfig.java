package com.db.recipes.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.db.recipes.repo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.port}")
    private int port;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public MongoClient mongoClient() {
        String connection = String.format("mongodb://%s:%d/%s", System.getenv("DB_HOST"), port, database);
        ConnectionString connectionString = new ConnectionString(connection);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.db.recipes");
    }
}
