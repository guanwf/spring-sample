package com.github.spring.sqldemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SQLDEMO
 *
 * @author Guanwf
 * @date 2019-06-25
 */
@SpringBootApplication(scanBasePackages = {
        "com.github.spring.sqldemo"
}, exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, RabbitAutoConfiguration.class})
@EnableAsync
public class SQLDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SQLDemoApplication.class).run(args);
    }

}