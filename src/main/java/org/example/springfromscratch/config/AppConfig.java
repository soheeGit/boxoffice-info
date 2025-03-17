package org.example.springfromscratch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.springfromscratch")
public class AppConfig {
    // 빈(Bean)
}
