package com.frostinteractive.scheduleapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.frostinteractive.scheduleapp")
@EntityScan(basePackages = "com.frostinteractive.scheduleapp.domain")
@EnableJpaRepositories(basePackages = "com.frostinteractive.scheduleapp.domain.repository")
@Import(value = CorsConfig.class)
public class ScheduleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleAppApplication.class, args);
    }

}

