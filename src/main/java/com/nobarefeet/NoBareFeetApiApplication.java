package com.nobarefeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.nobarefeet.controllers"})
@EntityScan({"com.nobarefeet.models"})
@EnableJpaRepositories({"com.nobarefeet.repositories"})
public class NoBareFeetApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoBareFeetApiApplication.class, args);
    }

}
