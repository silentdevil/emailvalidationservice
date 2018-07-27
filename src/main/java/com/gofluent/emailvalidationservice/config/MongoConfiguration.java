package com.gofluent.emailvalidationservice.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String MONGODB_HOST;

    @Value("${spring.data.mongodb.database}")
    private String MONGO_DBNAME;

    @Bean
    public MongoClient mongo() {
        return new MongoClient(MONGODB_HOST);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), MONGO_DBNAME);
    }

}
