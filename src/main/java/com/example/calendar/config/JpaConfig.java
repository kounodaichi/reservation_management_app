package com.example.calendar.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.example.calendar.model")
@EnableJpaRepositories(basePackages = "com.example.calendar.repository")
public class JpaConfig {
    // Configuration details if needed
}
