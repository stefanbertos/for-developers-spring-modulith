package com.example.demo.config;

import com.example.demo.converter.DateTimeToDateConverter;
import com.example.demo.converter.DateToDateTimeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Arrays;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory, MappingMongoConverter mongoConverter) {
        return new MongoTemplate(mongoDatabaseFactory, mongoConverter);
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory mongoDatabaseFactory, MongoMappingContext context) {
        var dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
        var mongoConverter = new MappingMongoConverter(dbRefResolver, context);
        mongoConverter.setCustomConversions(customConversions());

        return mongoConverter;
    }

    @Bean
    public CustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(new DateTimeToDateConverter(),
                new DateToDateTimeConverter()));
    }
}