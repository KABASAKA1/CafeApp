package com.sunrise.monetcafeapplicationapi.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.sunrise.monetcafeapplicationapi"})
@EntityScan(basePackages = {"com.sunrise.monetcafeapplicationapi"})
@EnableJpaRepositories(basePackages = {"com.sunrise.monetcafeapplicationapi"})
@EnableScheduling
@SpringBootApplication
public class MonetCafeApplicationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonetCafeApplicationApiApplication.class, args);
    }

}
